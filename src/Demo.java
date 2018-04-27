import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main( String[] args ) throws IOException {
        Player player = new Player();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // only support left or right now
            System.out.println("Record your meal:");
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                System.out.println("Error reading from input device");
            }
            System.out.println("You recorded your meal as " + s);

            if (s == "left") {
                player.left();
            } else {
                player.right();
            }
        }
    }
}