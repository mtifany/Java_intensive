package edu.school21.models;

public class Product {

    private Long id;

    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private String name;
    private Integer price;

    @Override
    public int hashCode() {
        return new org.apache.commons. lang.builder.HashCodeBuilder(17, 37).append(id).append(name).append(price).toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return new org.apache.commons.lang.builder.EqualsBuilder().append(id, product.id).append(price, product.price).append(name, product.name).isEquals();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
