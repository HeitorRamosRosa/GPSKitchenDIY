package pt.isec.supraindustries.kitchendiy


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import pt.isec.supraindustries.kitchendiy.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class teste_traducao {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun teste_traducao() {
        val button = onView(
allOf(withId(R.id.btnEscolherIngredientes), withText("CHOOSING THE INGREDIENTS"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button.check(matches(isDisplayed()))
        
        val button2 = onView(
allOf(withText("SEE RECIPES"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button2.check(matches(isDisplayed()))
        
        val button3 = onView(
allOf(withId(R.id.btnInformacoes), withText("INFORMATION"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button3.check(matches(isDisplayed()))
        
        val button4 = onView(
allOf(withId(R.id.btn_recomendar_receita), withText("RECOMMEND RECIPE"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button4.check(matches(isDisplayed()))
        
        val button5 = onView(
allOf(withId(R.id.btn_recomendar_ingrediente), withText("RECOMMEND INGREDIENT"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button5.check(matches(isDisplayed()))
        
        val spinner = onView(
allOf(withId(R.id.spinner),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        spinner.check(matches(isDisplayed()))
        
        val textView = onView(
allOf(withId(android.R.id.text1), withText("Select Language"),
withParent(allOf(withId(R.id.spinner),
withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
isDisplayed()))
        textView.check(matches(withText("Select Language")))
        
        val materialButton = onView(
allOf(withText("See Recipes"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
0),
2),
isDisplayed()))
        materialButton.perform(click())
        
        val textView2 = onView(
allOf(withId(R.id.row_receita_nome), withText("Chourizo Bread"),
withParent(withParent(withId(R.id.receitas_rv))),
isDisplayed()))
        textView2.check(matches(withText("Chourizo Bread")))
        
        val linearLayout = onData(anything())
.inAdapterView(allOf(withId(R.id.receitas_rv),
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
2)))
.atPosition(0)
        linearLayout.perform(click())
        
        val editText = onView(
allOf(withId(R.id.receita_nome), withText("Chourizo Bread"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText.check(matches(withText("Chourizo Bread")))
        
        val editText2 = onView(
allOf(withId(R.id.receita_ingredientes), withText("baker's yeast\nwheat flour\nchorizo\nflour\n"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText2.check(matches(withText("baker's yeast wheat flour chorizo flour ")))
        
        val editText3 = onView(
allOf(withId(R.id.receita_instruções), withText("1. Dissolve the yeast in the warm water, add a little flour and mix. Reserve. Mix the remaining flour with the salt and the baking powder and water. Knead very well, adding as much warm water as necessary to obtain a sufficiently consistent dough that does not cling to your hands. Cover the dough with a damp cloth and let it rise for half an hour, until it doubles in volume. \n2. Cut the chorizo into slices. After baking, roll out the dough on a floured surface and place a row of chorizo slices on top. Roll the dough a little, place another row of slices of chorizo and repeat the operation, until you get a roll.\n3. Sprinkle a tray with flour and place the bread on it. Make a few cuts on the surface of the dough and let it rise for another 20 minutes. Turn the oven to 200 ° C. Finally, take the bread in the middle of the oven and bake it for 30 minutes.\n"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText3.check(matches(withText("1. Dissolve the yeast in the warm water, add a little flour and mix. Reserve. Mix the remaining flour with the salt and the baking powder and water. Knead very well, adding as much warm water as necessary to obtain a sufficiently consistent dough that does not cling to your hands. Cover the dough with a damp cloth and let it rise for half an hour, until it doubles in volume.  2. Cut the chorizo into slices. After baking, roll out the dough on a floured surface and place a row of chorizo slices on top. Roll the dough a little, place another row of slices of chorizo and repeat the operation, until you get a roll. 3. Sprinkle a tray with flour and place the bread on it. Make a few cuts on the surface of the dough and let it rise for another 20 minutes. Turn the oven to 200 ° C. Finally, take the bread in the middle of the oven and bake it for 30 minutes. ")))
        
        pressBack()
        
        val materialButton2 = onView(
allOf(withId(R.id.btnInicio), withText("Home"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()))
        materialButton2.perform(click())
        
        val appCompatSpinner = onView(
allOf(withId(R.id.spinner),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
0),
5),
isDisplayed()))
        appCompatSpinner.perform(click())
        
        val checkedTextView = onView(
allOf(withId(android.R.id.text1), withText("Português"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
isDisplayed()))
        checkedTextView.check(matches(isDisplayed()))
        
        val checkedTextView2 = onView(
allOf(withId(android.R.id.text1), withText("English"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
isDisplayed()))
        checkedTextView2.check(matches(isDisplayed()))
        
        val appCompatCheckedTextView = onData(anything())
.inAdapterView(childAtPosition(
withClassName(`is`("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(1)
        appCompatCheckedTextView.perform(click())
        
        val button6 = onView(
allOf(withId(R.id.btnEscolherIngredientes), withText("ESCOLHER OS INGREDIENTES"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button6.check(matches(isDisplayed()))
        
        val button7 = onView(
allOf(withText("VER RECEITAS"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button7.check(matches(isDisplayed()))
        
        val button8 = onView(
allOf(withId(R.id.btnInformacoes), withText("INFORMAÇÕES"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button8.check(matches(isDisplayed()))
        
        val button9 = onView(
allOf(withId(R.id.btn_recomendar_receita), withText("RECOMENDAR RECEITA"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button9.check(matches(isDisplayed()))
        
        val button10 = onView(
allOf(withId(R.id.btn_recomendar_ingrediente), withText("RECOMENDAR INGREDIENTE"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        button10.check(matches(isDisplayed()))
        
        val spinner2 = onView(
allOf(withId(R.id.spinner),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        spinner2.check(matches(isDisplayed()))
        
        val materialButton3 = onView(
allOf(withText("Ver Receitas"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
0),
2),
isDisplayed()))
        materialButton3.perform(click())
        
        val textView3 = onView(
allOf(withId(R.id.row_receita_nome), withText("Pão com Chouriço"),
withParent(withParent(withId(R.id.receitas_rv))),
isDisplayed()))
        textView3.check(matches(withText("Pão com Chouriço")))
        
        val linearLayout2 = onData(anything())
.inAdapterView(allOf(withId(R.id.receitas_rv),
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
2)))
.atPosition(0)
        linearLayout2.perform(click())
        
        val editText4 = onView(
allOf(withId(R.id.receita_nome), withText("Pão com Chouriço"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText4.check(matches(withText("Pão com Chouriço")))
        
        val editText5 = onView(
allOf(withId(R.id.receita_ingredientes), withText("fermento de padeiro\nfarinha de trigo\nchouriço\nfarinha\n"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText5.check(matches(withText("fermento de padeiro farinha de trigo chouriço farinha ")))
        
        val editText6 = onView(
allOf(withId(R.id.receita_instruções), withText("1. Dissolva o fermento na água morna, junte um pouco da farinha e misture. Reserve. Misture a restante farinha com o sal e o preparado de fermento e água. Amasse muito bem, adicionando a água morna que for necessária para obter uma massa suficientemente consistente que não se agarre às mãos. Tape a massa com um pano húmido e deixe levedar durante meia hora, até dobrar de volume. \n2. Corte o chouriço em rodelas. Depois de lêveda, estenda a massa numa superfície polvilhada com farinha e coloque uma fila de rodelas de chouriço por cima. Enrole um pouco a massa, coloque mais uma fila de rodelas de chouriço e volte a repetir a operação, até obter um rolo.\n3. Polvilhe um tabuleiro com farinha e coloque o pão sobre o mesmo. Faça uns cortes na superfície da massa e deixe levedar, por mais 20 minutos. Ligue o forno a 200° C. Por fim, leve o pão a meio do forno e coza-o, durante 30 minutos.\n"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText6.check(matches(withText("1. Dissolva o fermento na água morna, junte um pouco da farinha e misture. Reserve. Misture a restante farinha com o sal e o preparado de fermento e água. Amasse muito bem, adicionando a água morna que for necessária para obter uma massa suficientemente consistente que não se agarre às mãos. Tape a massa com um pano húmido e deixe levedar durante meia hora, até dobrar de volume.  2. Corte o chouriço em rodelas. Depois de lêveda, estenda a massa numa superfície polvilhada com farinha e coloque uma fila de rodelas de chouriço por cima. Enrole um pouco a massa, coloque mais uma fila de rodelas de chouriço e volte a repetir a operação, até obter um rolo. 3. Polvilhe um tabuleiro com farinha e coloque o pão sobre o mesmo. Faça uns cortes na superfície da massa e deixe levedar, por mais 20 minutos. Ligue o forno a 200° C. Por fim, leve o pão a meio do forno e coza-o, durante 30 minutos. ")))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
