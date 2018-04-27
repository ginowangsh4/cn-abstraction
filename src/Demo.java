import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    public static void main( String[] args ) throws IOException {
        Player player = new Player();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Record your meal:");
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                System.out.println("Error reading from input device");
            }
            System.out.println("You recorded your meal as " + s);

            if (s.equals("low")) {
                player.low();
            } else {
                player.high();
            }

            if (player.current instanceof Winner ||
                    player.current instanceof Eliminated) {
                break;
            }
        }

        System.out.println("Ending Food Fight...");
    }
}