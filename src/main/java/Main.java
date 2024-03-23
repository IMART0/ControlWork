import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("src/main/java/schedule.txt"));
        List<Program> list = new ArrayList<Program>();
        Map<String, List<Program>> programs = new HashMap<>();
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
            programs.put(channel, channelList);
        }
        s.close();
        Collections.sort(list, Comparator.comparing(program -> program.getTime()));
        System.out.println(list);
        //7
        BroadcastsTime currentTime = new BroadcastsTime((byte) 14, (byte) 30); // Пример текущего времени
        for (Program program : list) {
            if (program.getTime().equals(currentTime)) {
                System.out.println(program.getName());
            }
        };

        //8
        String searchName = "Tatarstan today. Открытый миру";
        List<Program> foundPrograms = list.stream()
                .filter(program -> program.getName().equals(searchName))
                .collect(Collectors.toList());
        System.out.println(foundPrograms);

        //9
        BroadcastsTime currentTime1 = new BroadcastsTime((byte) 06, (byte) 00);
        String channelName = "#Первый";
        List<Program> channelPrograms = programs.get(channelName);
        if (channelPrograms != null) {
            for (Program program : channelPrograms) {
                if (program.getTime().equals(currentTime1)) {
                    System.out.println(program.getName());
                }
            }
        }
        //10
        BroadcastsTime startTime = new BroadcastsTime((byte) 5, (byte) 0);
        BroadcastsTime endTime = new BroadcastsTime((byte) 9, (byte) 0);
        for (Program program : channelPrograms) {
            if (program.getTime().between(startTime, endTime)) {
                System.out.println(program.getName());
            }
        }
    }
}
