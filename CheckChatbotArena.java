import javax.net.ssl.HttpsURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.Mixer;
import java.io.File;

public class CheckChatbotArena {
    private final static String URL_STRING = "https://huggingface.co/spaces/lmarena-ai/chatbot-arena-leaderboard"; //"https://www.lmarena.ai";
    private final static int AVERAGE_WAIT_TIME = 150; //s
    private final static int WAIT_TIME_STD_DEV = 150; //s
    private final static String SOUND_FILE_PATH = "/mnt/c/Users/alexa/Downloads/alarm.wav";
    public static String lastModified = "2024-12-23T11:00:26.000";
    
    public static void main(String[] args) throws Exception {
        Mixer.Info[] m = AudioSystem.getMixerInfo();
        System.out.println(m.length);
        for (Mixer.Info n: m) {
            System.out.println(n.getDescription());
        }
        SourceDataLine audioLine = null;
        AudioInputStream convertedStream = null;
        try {
            File soundFile = new File(SOUND_FILE_PATH);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat baseFormat = audioStream.getFormat();
            AudioFormat targetFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                44100,
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                44100,
                false
            );
            convertedStream = AudioSystem.getAudioInputStream(targetFormat, audioStream);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, targetFormat);
            audioLine = (SourceDataLine) AudioSystem.getLine(info);
            audioLine.open(targetFormat);
            Random random = new Random();
            while (true) {
                URL url = new URI(URL_STRING).toURL();
                //long startTime = System.currentTimeMillis();
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
                connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                connection.setRequestProperty("Connection", "keep-alive");
                connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
                connection.setRequestProperty("Sec-Fetch-Dest", "document");
                connection.setRequestProperty("Sec-Fetch-Mode", "navigate");
                connection.setRequestProperty("Sec-Fetch-Site", "same-origin");
                String raw_html = new String(connection.getInputStream().readAllBytes());
                //double time = (System.currentTimeMillis() - startTime) / 1000.0;
                String lastUpdated = raw_html.substring(
                        raw_html.indexOf("lastModified&quot;:&quot;2024-") + 25,
                        raw_html.indexOf("Z&quot;,&quot;likes&quot"));
                //raw_html.substring(raw_html.indexOf("Last updated: "), raw_html.indexOf("\n\nCode to recreate"));
                if (lastUpdated.equals(lastModified)) {
                    Date date = new Date();
                    System.out.print(date.toString() + " ");
                } else {
                    lastModified = new String(lastUpdated);
                    String message = "<html>IMPORTANT ALERT.<br>NOTIFY ALEX NOW!!<br><br>Update has changed:<br>" 
                            + lastModified + "<br><br>IMPORTANT ALERT.<br>NOTIFY ALEX NOW!!</html>";
                    System.out.println(message.replaceAll("<br>", "\n"));
                    JLabel label = new JLabel(message);
                    label.setFont(new Font("Arial", Font.BOLD, 120));
                    JPanel panel = new JPanel();
                    panel.add(label);
                    JOptionPane.showMessageDialog(null, panel, "NOTIFY ALEX NOW!!", JOptionPane.INFORMATION_MESSAGE);
                    audioLine.start();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = convertedStream.read(buffer)) != -1) {
                        audioLine.write(buffer, 0, bytesRead);
                    }
                }
                Thread.sleep(((long) Math.clamp(
                        random.nextGaussian(AVERAGE_WAIT_TIME, WAIT_TIME_STD_DEV),
                        Math.clamp(Math.random() * 20, 10, 60), 480))
                        * 1000);
            }
        } finally {
            if (audioLine != null) {
                audioLine.drain();
                audioLine.close();
            }
            if (convertedStream != null) {
                convertedStream.close();
            }
        }
    }
}
