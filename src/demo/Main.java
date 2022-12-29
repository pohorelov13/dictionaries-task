package demo;

public class Main {


    public static void main(String[] args) {

        FileNavigator fileNavigator = new FileNavigator();
        FileData file1 = new FileData("file1.txt", 100, "/path1/to/file");
        FileData file2 = new FileData("file2.java", 55, "/path1/to/file");
        FileData file3 = new FileData("file3.txt", 50, "/path1/to/file");
        FileData file4 = new FileData("file4.java", 200, "/path2/to/file");
        FileData file5 = new FileData("file5.txt", 40, "/path2/to/file");
        FileData file6 = new FileData("file6.txt", 0, "/path2/to/file");
        FileData file7 = new FileData("file7.txt", 60, "/path3/to/file");
        FileData file8 = new FileData("file8.txt", 95, "/path3/to/file");
        FileData file9 = new FileData("file9.java", 256, "/path3/to/file");
        FileData file10 = new FileData("file10.txt", 128, "/path4/to/file");
        fileNavigator.add(file1, "/another/path/to/file");
        fileNavigator.add(file2, "/path1/to/file");
        fileNavigator.add(file3, "/path1/to/file");
        fileNavigator.add(file4, "/path2/to/file");
        fileNavigator.add(file5, "/path2/to/file");
        fileNavigator.add(file6, "/path2/to/file");
        fileNavigator.add(file7, "/path3/to/file");
        fileNavigator.add(file8, "/path3/to/file");
        fileNavigator.add(file9, "/path3/to/file");
        fileNavigator.add(file10, "/path4/to/file");

        System.out.println(fileNavigator.getDictionary());

        fileNavigator.remove("/path2/to/file");

        System.out.println(fileNavigator.getDictionary());

        System.out.println(fileNavigator.find("/path3/to/file"));

        System.out.println(fileNavigator.filterBySize(60));

        System.out.println(fileNavigator.sortBySize());
    }

}