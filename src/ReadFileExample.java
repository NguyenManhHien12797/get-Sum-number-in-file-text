import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFileExample {
    public static void writeFileText() throws IOException {
        FileWriter writer = new FileWriter("sum.txt");
        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<5; i++){
            System.out.print("Nhập value vào file: ");
            String number= scanner.nextLine();

            writer.write(number);
            writer.write("\n");
        }

        writer.close();

    }
    public void readFileText(String filePath) throws FileNotFoundException {
        try{
            File file = new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null){
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();

            System.out.println("Tổng = "+ sum);
        }catch (Exception e){

            System.out.println("File không tồn tại hoặc nội dung có lỗi! ");

        }
    }

    public static void main(String[] args) throws IOException {
        writeFileText();

        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readfileEx = new ReadFileExample();
        readfileEx.readFileText(path);


    }



}
