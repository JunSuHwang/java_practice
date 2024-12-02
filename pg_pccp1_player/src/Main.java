public class Main {
    public static void main(String[] args) {
        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};
        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videolen = convert(video_len);
        int current = convert(pos);
        int opstart = convert(op_start);
        int opend = convert(op_end);

        for(String command : commands) {
            if (current >= opstart && current <= opend) current = opend;
            if(command.equals("next")) {
                current += 10;
                if (current > videolen) current = videolen;
            } else {
                current -= 10;
                if(current < 0) current = 0;
            }
        }

        if (current >= opstart && current <= opend) current = opend;

        return String.format("%02d",current / 60)+":"+String.format("%02d" ,current % 60);
    }

    public static int convert(String videotime) {
        int result = 0;
        result += Integer.parseInt(videotime.split(":")[0]) * 60;
        result += Integer.parseInt(videotime.split(":")[1]);

        return result;
    }
}