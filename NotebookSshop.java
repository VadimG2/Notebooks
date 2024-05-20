public class NotebookSshop {
    public class NotebookShop {
        private int id;
        private int RAM;
        private int HDDSize;
        private String OS;
        private String color;
    
        public NotebookShop(int id, int RAM, int HDDSize, String OS, String color) {
            this.id = id;
            this.RAM = RAM;
            this.HDDSize = HDDSize;
            this.OS = OS;
            this.color = color;
        }
    }
}
