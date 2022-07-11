public class Book {

        Integer id;
        String title;
        String category;
        String author;
        Double price;
        public Book() {
            super();

        }
        public Book(Integer id, String title, String category, String author, Double price) {
            super();
            this.id = id;
            this.title = title;
            this.category = category;
            this.author = author;
            this.price = price;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;}
        public void printt(){
            System.out.format("%-5s %-20s %-20s %-10s %s\n",this.id,this.title,this.category,this.author,this.price);
        }



    }


