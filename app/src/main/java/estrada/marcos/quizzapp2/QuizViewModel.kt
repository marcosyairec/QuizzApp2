package estrada.marcos.quizzapp2

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val question = listOf(
        Question(R.string.pregunta_continentes, respuesta = true),
        Question(R.string.pregunta_estados, respuesta = true),
        Question(R.string.pregunta_municipios, respuesta = true),
    )
    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionText: Int
        get() = question[currentIndex].textoPregunta

    val currentQuestionAnswer: Boolean
        get() = question[currentIndex].respuesta



    fun moveToNext() {
        currentIndex = (currentIndex + 1) % question.size
    }

    fun moveToPrevious() {
        currentIndex = (currentIndex - 1) % question.size
    }
}