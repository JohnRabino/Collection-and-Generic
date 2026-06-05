import java.util.*;

    public class Main {
        static List<Resident> residents = new ArrayList<>();
        static Set<String> zones = new HashSet<>();
        static Map<Resident, List<String>> complaints = new HashMap<>();
        static Scanner scanner = new Scanner(System.in);

        public static void addResident() {
            System.out.print("Enter Resident ID: ");
            String id = scanner.nextLine();

            for (Resident r : residents) {
                if (r.getResidentId().equals(id)) {
                    System.out.println("Error: Resident ID must be unique!");
                    return;
                }
            }

            System.out.print("Enter Resident Name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Resident must have a name!");
                return;
            }

            residents.add(new Resident(id, name));
            System.out.println("Resident added successfully!");
        }

        public static void viewAll() {
            if (residents.isEmpty()) {
                System.out.println("No residents yet!");
            } else {
                Collections.sort(residents);
                System.out.println("\nList of Residents:");
                System.out.println("Resident ID | Name");
                System.out.println("-------------------");
                for (Resident r : residents) {
                    System.out.println(r);
                }
            }
        }

        public static void searchResident() {
            System.out.print("Enter Resident ID to search: ");
            String id = scanner.nextLine();
            for (Resident r : residents) {
                if (r.getResidentId().equals(id)) {
                    System.out.println("Resident found: " + r.getResidentName());
                    return;
                }
            }
            System.out.println("Resident not found!");
        }

        public static void removeResident() {
            System.out.print("Enter Resident ID to remove: ");
            String id = scanner.nextLine();
            Iterator<Resident> it = residents.iterator();
            while (it.hasNext()) {
                Resident r = it.next();
                if (r.getResidentId().equals(id)) {
                    it.remove();
                    System.out.println("Resident removed successfully!");
                    return;
                }
            }
            System.out.println("Resident not found!");
        }

        public static void manageBZones() {
            System.out.println("Zones Menu:");
            System.out.println("1. Add Zone");
            System.out.println("2. View Zones");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Zone name: ");
                    String zone = scanner.nextLine();
                    zones.add(zone);
                    System.out.println("Zone added!");
                    break;
                case "2":
                    System.out.println("List of Barangay Zones:");
                    for (String z : zones) {
                        System.out.println(z);
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        public static void manageComplaints() {
            System.out.print("Enter Resident ID: ");
            String id = scanner.nextLine();
            Resident found = null;
            for (Resident r : residents) {
                if (r.getResidentId().equals(id)) {
                    found = r;
                    break;
                }
            }
            if (found == null) {
                System.out.println("Resident not found!");
                return;
            }

            System.out.println("Complaints Menu:");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter complaint: ");
                    String c = scanner.nextLine();
                    complaints.putIfAbsent(found, new ArrayList<>());
                    complaints.get(found).add(c);
                    System.out.println("Complaint added!");
                    break;
                case "2":
                    List<String> list = complaints.get(found);
                    if (list == null || list.isEmpty()) {
                        System.out.println("No complaints for this resident.");
                    } else {
                        System.out.println("Complaints for " + found.getResidentName() + ":");
                        for (String comp : list) {
                            System.out.println("- " + comp);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        public static void clearAll() {
            residents.clear();
            zones.clear();
            complaints.clear();
            System.out.println("All data cleared!");
        }

        public static void countTotal() {
            System.out.println("Total number of residents: " + residents.size());
        }

        public static void menu() {
            while (true) {
                System.out.println("\n===== Barangay Resident Management System =====");
                System.out.println("1. Add Resident");
                System.out.println("2. Remove Resident");
                System.out.println("3. Search Resident");
                System.out.println("4. View All Residents (Sorted)");
                System.out.println("5. Manage Barangay Zones");
                System.out.println("6. Manage Complaints");
                System.out.println("7. Clear All Data");
                System.out.println("8. Count Total Residents");
                System.out.println("9. Exit");

                System.out.print("Enter choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1": addResident(); break;
                    case "2": removeResident(); break;
                    case "3": searchResident(); break;
                    case "4": viewAll(); break;
                    case "5": manageBZones(); break;
                    case "6": manageComplaints(); break;
                    case "7": clearAll(); break;
                    case "8": countTotal(); break;
                    case "9":
                        System.out.println("THANK YOU FOR USING IT, EXITING THE PROGRAM, HAVE A NICE DAY!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }

        public static void main(String[] args) {
            menu();
        }
    }
