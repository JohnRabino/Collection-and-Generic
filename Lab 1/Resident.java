

public class Resident implements Comparable<Resident> {
    private String residentId;
    private String residentName;

    public Resident(String residentId, String residentName) {
        this.residentId = residentId;
        this.residentName = residentName;
    }

    public String getResidentId() {
        return residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    @Override
    public int compareTo(Resident other) {
        return this.residentName.compareToIgnoreCase(other.residentName);
    }

    @Override
    public String toString() {
        return residentId + " | " + residentName;
    }
}

