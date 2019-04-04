package interview.main;

import interview.io.impl.FileInput;
import interview.io.impl.FileOutput;
import interview.service.IFindAcutualActivationDateService;
import interview.service.impl.FindActualActivationDateService;

public class Application {
    public static void main(String[] args) {
        IFindAcutualActivationDateService service = new FindActualActivationDateService();

        if (args.length == 2) {
            String inputPath = args[0];
            String outputPath = args[1];
            service.find(new FileInput(inputPath), new FileOutput(outputPath));
        } else {
            throw new IllegalArgumentException("file path of input and out put must be provided");
        }

    }
}
