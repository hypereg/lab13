package controller;

import model.Pracownik;
import java.io.*;
import java.util.List;
import java.util.zip.*;

public class BackupController {
    public void saveToGzipFile(List<Pracownik> employees, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(employees);
        }
    }

    public List<Pracownik> loadFromGzipFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new GZIPInputStream(new FileInputStream(fileName)))) {
            return (List<Pracownik>) ois.readObject();
        }
    }

    public void saveToZipFile(List<Pracownik> employees, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            ZipEntry entry = new ZipEntry("employees");
            zos.putNextEntry(entry);
            ObjectOutputStream oos = new ObjectOutputStream(zos);
            oos.writeObject(employees);
            oos.flush();
            zos.closeEntry();
        }
    }

    public List<Pracownik> loadFromZipFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ZipInputStream zis = new ZipInputStream(fis)) {
            ZipEntry entry = zis.getNextEntry();
            if (entry != null && "employees".equals(entry.getName())) {
                try (ObjectInputStream ois = new ObjectInputStream(zis)) {
                    return (List<Pracownik>) ois.readObject();
                }
            } else {
                throw new IOException("Blad w zipie");
            }
        }
    }
}