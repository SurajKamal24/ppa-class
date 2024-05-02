package serializationdeserialization;

public class ReportCard {
    private final int id;
    private final ScienceMarks scienceMarks;
    private final ArtsMarks artsMarks;
    private final double totalPercentage;
    public ReportCard() {
        this.id = 0;
        this.scienceMarks = null;
        this.artsMarks = null;
        this.totalPercentage = 0.0;
    }
    public ReportCard(int id, ScienceMarks scienceMarks, ArtsMarks artsMarks, double totalPercentage) {
        this.id = id;
        this.scienceMarks = scienceMarks;
        this.artsMarks = artsMarks;
        this.totalPercentage = totalPercentage;
    }
    public int getId() {
        return id;
    }
}
