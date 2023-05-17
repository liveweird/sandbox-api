package sandbox.api

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import aws.sdk.kotlin.services.translate.TranslateClient
import aws.sdk.kotlin.services.translate.model.TranslateTextRequest

@Controller("/translate")
class TranslateController {

    @Get(produces = ["text/plain"])
    suspend fun index(): String {
        TranslateClient { region = "eu-central-1" }.use { client ->
            return client.translateText(TranslateTextRequest {
                sourceLanguageCode = "en"
                targetLanguageCode = "de"
                text = "Hello World"
            }).translatedText.orEmpty()
        }
    }
}