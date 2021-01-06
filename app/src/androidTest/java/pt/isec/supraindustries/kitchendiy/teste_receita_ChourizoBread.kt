package pt.isec.supraindustries.kitchendiy


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class teste_receita_ChourizoBread {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun teste_receita_ChourizoBread() {
        val materialButton = onView(
            allOf(
                withText("See Recipes"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val linearLayout = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.receitas_rv),
                    childAtPosition(
                        withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                        2
                    )
                )
            )
            .atPosition(0)
        linearLayout.perform(click())

        val editText = onView(
            allOf(
                withId(R.id.receita_nome), withText("Chourizo Bread"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        editText.check(matches(withText("Chourizo Bread")))

        val editText2 = onView(
            allOf(
                withId(R.id.receita_ingredientes),
                withText("baker's yeast\nwheat flour\nchorizo\nflour\n"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("baker's yeast\nwheat flour\nchorizo\nflour\n")))

        val editText3 = onView(
            allOf(
                withId(R.id.receita_instruções),
                withText("1. Dissolve the yeast in the warm water, add a little flour and mix. Reserve. Mix the remaining flour with the salt and the baking powder and water. Knead very well, adding as much warm water as necessary to obtain a sufficiently consistent dough that does not cling to your hands. Cover the dough with a damp cloth and let it rise for half an hour, until it doubles in volume. \n2. Cut the chorizo into slices. After baking, roll out the dough on a floured surface and place a row of chorizo slices on top. Roll the dough a little, place another row of slices of chorizo and repeat the operation, until you get a roll.\n3. Sprinkle a tray with flour and place the bread on it. Make a few cuts on the surface of the dough and let it rise for another 20 minutes. Turn the oven to 200 ° C. Finally, take the bread in the middle of the oven and bake it for 30 minutes.\n"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        editText3.check(matches(withText("1. Dissolve the yeast in the warm water, add a little flour and mix. Reserve. Mix the remaining flour with the salt and the baking powder and water. Knead very well, adding as much warm water as necessary to obtain a sufficiently consistent dough that does not cling to your hands. Cover the dough with a damp cloth and let it rise for half an hour, until it doubles in volume. \n2. Cut the chorizo into slices. After baking, roll out the dough on a floured surface and place a row of chorizo slices on top. Roll the dough a little, place another row of slices of chorizo and repeat the operation, until you get a roll.\n3. Sprinkle a tray with flour and place the bread on it. Make a few cuts on the surface of the dough and let it rise for another 20 minutes. Turn the oven to 200 ° C. Finally, take the bread in the middle of the oven and bake it for 30 minutes.\n")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

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
