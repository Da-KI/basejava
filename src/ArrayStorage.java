/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else break;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume r :
                storage) {
            if (r == null) break;
            if (r.uuid.equals(uuid)) return r;
        }
        return null;
    }

    void delete(String uuid) {
        boolean isDeleted = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) break;
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[1 + i];
                isDeleted = true;
            }
            if (isDeleted) {
                storage[i] = storage[1 + i];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size()];
        System.arraycopy(storage, 0, result, 0, result.length);
        return result;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            } else break;
        }
        return count;
    }
}
