
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    @FXML private TextArea message;
    @FXML private TextField result;
    @FXML private Label labelError;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        result.setText("" + numPixels(message.getText()));
    }
    
    
    private int numPixels(String text){
        int total = 0;
        String out = "";
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a': case 'á': case 'b': case 'c': case 'd': case 'e': case 'é': case 'g': case 'h': case 'n': case 'ñ': case 'o': case 'ó': case 'p': case 'q': case 's': case 'ú': case 'y': case 'z': case 'E': case 'É': case 'F': case 'K': case 'L': case 'X': case '?': case '¿':
                    total += 8;
                    break;
                case 'f': case 'r': case 't': case ' ':
                    total += 6;
                    break;
                case 'i': case 'l': case '!': case '¡':
                    total += 3;
                    break;
                case 'í': case '.': case ',':
                    total += 4;
                    break;
                case 'j': case 'I': case '(': case ')':
                    total += 5;
                    break;
                case 'k': case 'u': case 'x': case 'J':
                    total += 7;
                    break;
                case 'A': case 'C': case 'G':
                    total += 10;
                    break;
                case 'v': case 'B': case 'D': case 'H': case 'N': case 'P': case 'R': case 'S': case 'T': case 'U': case 'V': case 'Y': case 'Z':
                    total += 9;
                    break;
                case 'w': case 'M': case 'O': case 'Q':
                    total += 11;
                    break;
                case 'W':
                    total += 13;
                    break;
                default:
                    out = msgError() + " Carácter inválido: ";
                    switch(text.charAt(i)){
                        // This is meant to include more cases as time goes on
                        case '\n': out += "Salto de línea"; break;
                        default: out += text.charAt(i);
                    }
                    labelError.setText(out);
                    return -1;
            }
        }
        if(total >= 231){
            out = msgError();
            labelError.setText(out + " El texto supera el tamaño permitido: " + total + " >= 231");
            return -2;
        } else {
            out = msgOK();
            labelError.setText(out + " Mensaje calculado sin errores");
        }
        return total;
    }
    
    private int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    private String msgError(){
        String msg = "";
        switch(randInt(0,4)){
            case 0: msg += "Acta del juicio actualizada..."; break;
            case 1: msg += "Reinicia el caso..."; break;
            case 2: msg += "¡Última oportunidad!"; break;
            case 3: msg += "Aquí no hay loro que valga."; break;
            default: msg += "El distintivo no sirve como prueba..."; break;
        }
        return msg;
    }
    
    private String msgOK(){
        String msg = "";
        switch(randInt(0,3)){
            case 0: msg += "¡Toma ya!"; break;
            case 1: msg += "¡Ya lo tengo!"; break;
            case 2: msg += "¡Protesto!"; break;
            default: msg += "¡Un momento!"; break;
        }
        return msg;
    }
}
