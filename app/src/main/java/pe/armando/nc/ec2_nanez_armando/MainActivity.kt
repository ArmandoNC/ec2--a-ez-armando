package pe.armando.nc.ec2_nanez_armando

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import pe.armando.nc.ec2_nanez_armando.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                QuestionnaireScreen()
            }
        }
    }
}

@Composable
fun QuestionnaireScreen() {
    var selectedSignificance by remember { mutableStateOf("Mucho") }
    var selectedPayment by remember { mutableStateOf("Bien") }
    var worksUnderPressure by remember { mutableStateOf(true) }
    var hasGrowthOpportunity by remember { mutableStateOf(true) }
    val skills = remember { mutableStateMapOf(
        "Autoconocimiento" to false,
        "Empatía" to false,
        "Comunicación asertiva" to false,
        "Toma de decisiones" to false,
        "Pensamiento crítico" to false,
        "Ninguno" to false
    )}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "CUESTIONARIO",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("1. Marque sus habilidades.")
        skills.forEach { (skill, selected) ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = selected, onCheckedChange = { skills[skill] = it })
                Text(skill)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("2. ¿Cuán significativo es tu trabajo?")
        Row {
            RadioButton(selected = selectedSignificance == "Mucho", onClick = { selectedSignificance = "Mucho" })
            Text("Mucho")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedSignificance == "Más o menos", onClick = { selectedSignificance = "Más o menos" })
            Text("Más o menos")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedSignificance == "Poco", onClick = { selectedSignificance = "Poco" })
            Text("Poco")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("3. ¿Qué tan bien te pagan en el trabajo que haces?")
        Row {
            RadioButton(selected = selectedPayment == "Bien", onClick = { selectedPayment = "Bien" })
            Text("Bien")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedPayment == "Regular", onClick = { selectedPayment = "Regular" })
            Text("Regular")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedPayment == "Mal", onClick = { selectedPayment = "Mal" })
            Text("Mal")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("4. ¿Trabajas bajo presión?")
        Row {
            RadioButton(selected = worksUnderPressure, onClick = { worksUnderPressure = true })
            Text("SI")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = !worksUnderPressure, onClick = { worksUnderPressure = false })
            Text("NO")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("5. ¿Tienes oportunidad de crecimiento en tu trabajo?")
        Row {
            RadioButton(selected = hasGrowthOpportunity, onClick = { hasGrowthOpportunity = true })
            Text("SI")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = !hasGrowthOpportunity, onClick = { hasGrowthOpportunity = false })
            Text("NO")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { }) {
                Text("Resolver")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        QuestionnaireScreen()
    }
}
