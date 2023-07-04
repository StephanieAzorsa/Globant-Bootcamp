package guide08.exercises.exercise08;

import guide08.exercises.exercise08.entities.Text;
import guide08.exercises.exercise08.services.TextAnalyserService;


public class TextAnalyser {
    public static void main(String[] args) {
        TextAnalyserService tas = new TextAnalyserService();
        Text text = tas.readPhrase();

        tas.showMenu(text);
    }
}
