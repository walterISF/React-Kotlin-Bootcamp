package logo

import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.html.style

@JsModule("src/logo/bracelet.svg")
external val reactLogo: dynamic
@JsModule("src/logo/charmander.svg")
external val kotlinLogo: dynamic
@JsModule("src/logo/santa-claus.svg")
external val santaClaus: dynamic

fun RBuilder.logo(height: Int = 100) {
    div("Logo") {
        attrs.jsStyle.height = height
        img(alt = "React logo.logo", src = reactLogo, classes = "Logo-react") {}
        img(alt = "Kotlin logo.logo", src = kotlinLogo, classes = "Logo-kotlin") {}
    }
}

fun RBuilder.logoSanta(height: Int = 100)
{
    div {
        attrs.jsStyle.height = height
        img (alt = "Santa Claus.logo", src = santaClaus, classes = "Logo-santa") {}
    }
}
