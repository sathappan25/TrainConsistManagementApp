import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidationService {

    // Regex patterns
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    private Pattern trainPattern;
    private Pattern cargoPattern;

    public ValidationService() {
        trainPattern = Pattern.compile(TRAIN_ID_REGEX);
        cargoPattern = Pattern.compile(CARGO_CODE_REGEX);
    }

    public boolean isValidTrainId(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = trainPattern.matcher(trainId);
        return matcher.matches();
    }

    public boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = cargoPattern.matcher(cargoCode);
        return matcher.matches();
    }
}