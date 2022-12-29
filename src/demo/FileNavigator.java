package demo;

import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> dictionary = new HashMap<>();

    void add(FileData fileData, String path) {
        if (fileData.getPath().equals(path)) {
            if (!dictionary.containsKey(path)) {
                List<FileData> list = new ArrayList<>();
                list.add(fileData);
                dictionary.put(path, list);
            } else dictionary.get(path).add(fileData);
        } else System.out.println(fileData.getName() + " don't add. Key path and file path do not match");
    }

    List<FileData> find(String path) {
        List<FileData> list = new ArrayList<>();
        if (dictionary.containsKey(path)) {
            list.addAll(dictionary.get(path));
        }
        return list;
    }

    List<FileData> filterBySize(int size) {
        List<FileData> listAll = new ArrayList<>();
        List<FileData> filterList = new ArrayList<>();
        {
            for (List<FileData> fileList :
                    dictionary.values()) {
                listAll.addAll(fileList);
            }
            for (FileData file :
                    listAll) {
                if (file.getSize() <= size) {
                    filterList.add(file);
                }
            }
        }
        return filterList;
    }

    void remove(String path) {
        dictionary.remove(path);
    }

    List<FileData> sortBySize() {
        List<FileData> listAl1l = new ArrayList<>();
        for (List<FileData> fileList :
                dictionary.values()) {
            listAl1l.addAll(fileList);
        }
        FileData[] arrFiles = new FileData[listAl1l.size()];

        for (int i = 0; i < listAl1l.size(); i++) {
            arrFiles[i] = listAl1l.get(i);
        }

        for (int i = 0; i < arrFiles.length; i++) {
            for (int j = 0; j < arrFiles.length - i - 1; j++) {
                if (arrFiles[j + 1].getSize() < arrFiles[j].getSize()) {
                    FileData swap = arrFiles[j];
                    arrFiles[j] = arrFiles[j + 1];
                    arrFiles[j + 1] = swap;
                }
            }
        }
        return Arrays.stream(arrFiles).toList();
    }

    public Map<String, List<FileData>> getDictionary() {
        return dictionary;
    }
}