import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("src/main/java/schedule.txt"));
        List<Program> list = new ArrayList<Program>();
        Map<String, List<Program>> program = new HashMap<>();
        String read = s.nextLine();
        while (s.hasNextLine()){
            String channel = read;
            read = s.nextLine();
            List<Program> channelList = new ArrayList<Program>();
            while ((read.charAt(0) != '#') && (s.hasNextLine())) {
                BroadcastsTime data = new BroadcastsTime(read);
                String name = s.nextLine();
                list.add(new Program(channel, data, name));
                channelList.add(new Program(channel, data, name));
                if (s.hasNextLine())
                    read = s.nextLine();
            };
            program.put(channel, channelList);
        }
        s.close();
        System.out.println(program);
    }
}
