package com.sebastianb.menu

import android.annotation.SuppressLint
import android.app.Activity

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.sebastianb.menu.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : Activity() {
    private lateinit var mainBinding: ActivityMainBinding  //Declaramos pero no la inicializamos
    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        val tomateCheckBox: CheckBox = findViewById(R.id.checkBox7)
        val lechugaCheckBox: CheckBox = findViewById(R.id.checkBox6)
        val cebollaCheckBox: CheckBox = findViewById(R.id.checkBox5)
        val tocinetaCheckBox: CheckBox = findViewById(R.id.checkBox3)
        val cebolla_caraCheckbox: CheckBox = findViewById(R.id.checkBox2)
        val queso_mozarellaCheckbox: CheckBox = findViewById(R.id.checkBox)
        var vegetales = ""
        var adicion = ""





        mainBinding.buttonPedir.setOnClickListener{
            if (mainBinding.emailEditText.text?.isEmpty() == true || mainBinding.nameTextFile.text?.isEmpty() == true || mainBinding.celularTextFile.text?.isEmpty() == true|| mainBinding.celularTextFile.length() <10 || mainBinding.celularTextFile.length()>10 || mainBinding.emailEditText.length()<11 || mainBinding.nameTextFile.length()<3) {
                Toast.makeText(this, getString(R.string.ingresar_campos), Toast.LENGTH_SHORT).show()

                if (mainBinding.emailEditText.text?.isEmpty() == true)
                    mainBinding.emailEditText.error = getString(R.string.ingresar_email)
                if (mainBinding.nameTextFile.length()<3)
                    mainBinding.nameTextFile.error=getString(R.string.nombre_minimo)

                if (mainBinding.emailEditText.length()<11)
                    mainBinding.emailEditText.error=getString(R.string.digite_direccion)

                if (mainBinding.nameTextFile.text?.isEmpty() == true)
                    mainBinding.nameTextFile.error = getString(R.string.digite_nombre)

                if (mainBinding.celularTextFile.length()<10 || mainBinding.celularTextFile.length()>10 )
                    mainBinding.celularTextFile.error = getString(R.string.digite_numcelular)

                if (mainBinding.celularTextFile.text?.isEmpty() == true)
                    mainBinding.celularTextFile.error = getString(R.string.digite_celular)

                mainBinding.textView.text=null

            }
            else {
                Toast.makeText(this,getString(R.string.datos_registrados),Toast.LENGTH_SHORT).show()

            }

            }




        mainBinding.pedirBotton.setOnClickListener {

            val pan_spin: Spinner = findViewById(R.id.spinner)
            val proteina_spinner: Spinner = findViewById(R.id.spinner4)
            val queso_spinner: Spinner = findViewById(R.id.spinner3)
            val salsa_spinner: Spinner = findViewById(R.id.spinner8)
            val acom_spinner: Spinner = findViewById(R.id.spinner9)
            val bebida_spinner: Spinner = findViewById(R.id.spinner10)

            val pann = pan_spin.selectedItem.toString()
            val proteina = proteina_spinner.selectedItem.toString()
            val queso = queso_spinner.selectedItem.toString()
            val salsap = salsa_spinner.selectedItem.toString()
            val acomp = acom_spinner.selectedItem.toString()
            val bebidap = bebida_spinner.selectedItem.toString()
            var valor_hamburguesa = 0
            var panv = 0
            var quesov = 0
            var protev = 0
            var salsav = 0
            var bebidav = 0
            var acompv = 0
            var vegetalesv = 0
            var adicionesv = 0
            if (tomateCheckBox.isChecked) vegetales = getString(R.string.tomate)
            if (lechugaCheckBox.isChecked) vegetales = vegetales + " " + getString(R.string.lechuga)
            if (cebollaCheckBox.isChecked) vegetales = vegetales + " " + getString(R.string.lechuga)
            if (tocinetaCheckBox.isChecked) adicion = adicion + " " + getString(R.string.tocineta)
            if (cebolla_caraCheckbox.isChecked) adicion =
                adicion + " " + getString(R.string.cebolla_caramelizado)
            if (queso_mozarellaCheckbox.isChecked) adicion =
                adicion + " " + getString(R.string.queso_mozarella)


            if (pann == "Pan tradicional") panv = 4000
            if (pann == "Pan Integral") panv = 4000
            if (pann == "Pan de papa") panv = 4500
            if (queso == "Queso cheddar") quesov = 3000
            if (queso == "Queso mozarella") quesov = 3000
            if (queso == "Queso americano") quesov = 3000
            if (queso == "Queso azul") quesov = 3500
            if (queso == "Sin queso") quesov = 0
            if (proteina == "Carne de cerdo") protev = 5000
            if (proteina == "Carne de res") protev = 5000
            if (proteina == "Pollo crispy") protev = 5500
            if (salsap == "Salsa de tomate") salsav = 1500
            if (salsap == "Mayonesa") salsav = 1500
            if (salsap == "Salsa bbq") salsav = 1500
            if (salsap == "Salsa de queso") salsav = 1500
            if (salsap == "Salsa de ajo") salsav = 1500
            if (salsap == "Con todas las salsas") salsav = 2500
            if (salsap == "Sin salsas") salsav = 0
            if (bebidap == "Sin bebida") bebidav = bebidav - 2000
            if (bebidap == "Coca col" || bebidap == "Sprite" || bebidap == "Limonada" || bebidap == "Pepsi" || bebidap == "Colombiana" || bebidap == "Coca cola zero" || bebidap == "Agua con gas" || bebidap == "Agua sin gas") bebidav =
                2000

            if (acomp == "Cascos") acompv = 3000
            if (acomp == "Papas a la francesa") acompv = 3000
            if (acomp == "Chips") acompv = 3000
            if (acomp == "Platanitos") acompv = 3000
            if (acomp == "sin acompañamiento") acompv = 0
            if (tomateCheckBox.isChecked || lechugaCheckBox.isChecked || cebollaCheckBox.isChecked) vegetalesv =
                2000
            if (tocinetaCheckBox.isChecked) adicionesv = adicionesv + 2000
            if (cebolla_caraCheckbox.isChecked) adicionesv = adicionesv + 2000
            if (queso_mozarellaCheckbox.isChecked) adicionesv = adicionesv + 2000

            valor_hamburguesa =
                quesov + protev + salsav + bebidav + acompv + vegetalesv + adicionesv + panv

            val nombres = mainBinding.nameTextFile.text.toString()
            val emailu = mainBinding.emailEditText.text.toString()
            val celular = mainBinding.celularTextFile.text.toString()


            if (mainBinding.emailEditText.text?.isEmpty() == true || mainBinding.nameTextFile.text?.isEmpty() == true || mainBinding.celularTextFile.text?.isEmpty() == true|| celular.length <10 || mainBinding.celularTextFile.length()>10 || mainBinding.emailEditText.length()<11 || mainBinding.nameTextFile.length()<3) {
                Toast.makeText(this, getString(R.string.ingresar_campos), Toast.LENGTH_SHORT).show()

                if (mainBinding.emailEditText.text?.isEmpty() == true)
                    mainBinding.emailEditText.error = getString(R.string.ingresar_email)
                if (mainBinding.nameTextFile.length()<3)
                    mainBinding.nameTextFile.error=getString(R.string.nombre_minimo)

                if (mainBinding.emailEditText.length()<11)
                    mainBinding.emailEditText.error=getString(R.string.digite_direccion)

                if (mainBinding.nameTextFile.text?.isEmpty() == true)
                    mainBinding.nameTextFile.error = getString(R.string.digite_nombre)

                if (mainBinding.celularTextFile.length()<10 || mainBinding.celularTextFile.length()>10 )
                    mainBinding.celularTextFile.error = getString(R.string.digite_numcelular)

                if (mainBinding.celularTextFile.text?.isEmpty() == true)
                    mainBinding.celularTextFile.error = getString(R.string.digite_celular)



            }
            else {val final = valor_hamburguesa.toString()
                mainBinding.textView.text = getString(R.string.valorapagar)+" "+final+" "+"COP"

            }

         }
    }
}
