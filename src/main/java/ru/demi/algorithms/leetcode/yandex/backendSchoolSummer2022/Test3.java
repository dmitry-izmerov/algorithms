package ru.demi.algorithms.leetcode.yandex.backendSchoolSummer2022;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test3 {

    private static final int FILTERS = 5;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String s = r.readLine();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(s);
        List<Product> products = new ArrayList<>();
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            products.add(mapProduct(jsonObject));
        }
        List<Predicate<Product>> predicates = new ArrayList<>();
        for (int i = 0; i < FILTERS; i++) {
            predicates.add(parseProductFilter(r.readLine()));
        }
        List<Map<String, String>> result = products.stream()
            .filter(product -> predicates.stream().allMatch(p -> p.test(product)))
            .sorted()
            .map(Test3::toMap)
            .collect(Collectors.toList());

        System.out.println(JSONArray.toJSONString(result));
    }

    private static Predicate<Product> parseProductFilter(String filterStr) {
        String[] split = filterStr.split(" ");
        String name = split[0];
        switch (name) {
            case "NAME_CONTAINS": {
                return getNameContains(split[1]);
            }
            case "PRICE_GREATER_THAN": {
                return getPriceGreaterThan(Integer.parseInt(split[1]));
            }
            case "PRICE_LESS_THAN": {
                return getPriceLessThan(Integer.parseInt(split[1]));
            }
            case "DATE_BEFORE": {
                return getDateBefore(LocalDate.parse(split[1], DATE_FORMATTER));
            }
            case "DATE_AFTER": {
                return getDateAfter(LocalDate.parse(split[1], DATE_FORMATTER));
            }
            default:
                throw new RuntimeException("Unknown filter name");
        }
    }

    private static Predicate<Product> getNameContains(String name) {
        return (product) -> product.name.contains(name);
    }

    private static Predicate<Product> getPriceGreaterThan(int price) {
        return (product) -> product.price > price || product.price == price;
    }

    private static Predicate<Product> getPriceLessThan(int price) {
        return (product) -> product.price < price || product.price == price;
    }

    private static Predicate<Product> getDateBefore(LocalDate date) {
        return (product) -> product.date.isBefore(date) || product.date.equals(date);
    }

    private static Predicate<Product> getDateAfter(LocalDate date) {
        return (product) -> product.date.isAfter(date) || product.date.equals(date);
    }

    private static Product mapProduct(JSONObject jsonObject) {
        long id = (long) jsonObject.get("id");
        String name = (String) jsonObject.get("name");
        long price = (long) jsonObject.get("price");
        LocalDate date = LocalDate.parse((String) jsonObject.get("date"), DATE_FORMATTER);
        return new Product(id, name, price, date);
    }

    private static Map<String, String> toMap(Product product) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("id", Long.toString(product.id));
        map.put("name", product.name);
        map.put("price", Long.toString(product.price));
        map.put("date", product.date.format(DATE_FORMATTER));
        return map;
    }

    private static final class Product implements Comparable<Product> {
        private final long id;
        private final String name;
        private final long price;
        private final LocalDate date;

        private Product(long id, String name, long price, LocalDate date) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.date = date;
        }

        public long id() {
            return id;
        }

        public String name() {
            return name;
        }

        public long price() {
            return price;
        }

        public LocalDate date() {
            return date;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            Product that = (Product) obj;
            return this.id == that.id &&
                    Objects.equals(this.name, that.name) &&
                    this.price == that.price &&
                    Objects.equals(this.date, that.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, price, date);
        }

        @Override
        public String toString() {
            return "Product[" +
                    "id=" + id + ", " +
                    "name=" + name + ", " +
                    "price=" + price + ", " +
                    "date=" + date + ']';
        }

        @Override
        public int compareTo(Product o) {
            return (int) (id - o.id);
        }
    }
}
