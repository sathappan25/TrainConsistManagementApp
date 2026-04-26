import java.util.List;

public class SafetyService {

    // UC12: Safety compliance
    public boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        // All cylindrical bogies must carry Petroleum
        return goodsBogies.stream()
                .allMatch(bogie -> 
                    !bogie.getType().equalsIgnoreCase("Cylindrical") 
                    || bogie.getCargo().equalsIgnoreCase("Petroleum")
                );
    }
}