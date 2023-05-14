package sandbox.api

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import aws.sdk.kotlin.services.translate.TranslateClient

@Controller("/translate")
class TranslateController {

    @Get(produces = ["text/plain"])
    suspend fun index(): String {
        // val translateClient = TranslateClient { region = "eu-central-1" }
        // return translateClient.translateText("Hello World", "de", "en").translatedText ?: "No translation"
        return "Hello World"
    }
}