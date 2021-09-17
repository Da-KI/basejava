package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if(isResumeExist(r.getUuid())) {
            System.out.println("Resume with uuid " + r.getUuid() + " already exist");
        }
        else {
            if(size == 9999) {
                System.out.println("Storage is overfill");
            }
            else {
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        if(isResumeExist(uuid)) {
            for (Resume r :
                    storage) {
                if (r == null) break;
                if (r.getUuid().equals(uuid)) return r;
            }
        }
        else {
            System.out.println("Resume with uuid " + uuid + " doesn't exist");
        }
        return null;
    }

    public void delete(String uuid) {
        if(isResumeExist(uuid)) {
            boolean isDeleted = false;
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    isDeleted = true;
                    size--;
                }
                if (isDeleted) {
                    storage[i] = storage[1 + i];
                }
            }
        }
        else {
            System.out.println("Resume with uuid " + uuid + " doesn't exist");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        if(isResumeExist(resume.getUuid())) {
            Resume old = get(resume.getUuid());
            old = resume;
        }
        else {
            System.out.println("Resume with uuid " + resume.getUuid() + " doesn't exist");
        }
    }

    boolean isResumeExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

}
