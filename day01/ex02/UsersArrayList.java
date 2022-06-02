

class UserNotFoundException extends RuntimeException {}

    public class UsersArrayList implements UsersList {
        private User[] array;
        private Integer size;

        private static Integer DEFAULT_SIZE = 10;

        public UsersArrayList() {
            array = new User[DEFAULT_SIZE];
            size = 0;
        }

        @Override
        public void add(User user) {
            if (array.length == size) {
                User[] newArray = new User[size + size];
                for (int i = 0; i < size; i++) {
                    newArray[i] = array[i];
                }
                array = newArray;
            }
            array[size] = user;
            size++;
        }

        @Override
        public User getbyId(Integer identifier) {
            for (int i = 0; i < size; i++) {
                if (identifier.equals(array[i].getIdentifier())) {
                    return array[i];
                }
            }
            throw new UserNotFoundException();
        }

        @Override
        public User getbyIndex(Integer index) {
            if (index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return array[index];
        }

        @Override
        public Integer NumberofUsers() {
            return size;
        }
}