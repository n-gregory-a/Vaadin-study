package com.nga.vaadinstudy;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerService {

    private static CustomerService instance;
    private static final Logger LOGGER = Logger.getLogger((CustomerService.class.getName()));

    private final HashMap<Long, Customer> contacts = new HashMap<>();
    private long nextId = 0;

    public CustomerService() {
    }

    /**
     * @return a reference to an example facade for Customer objects.
     */
    public static CustomerService getInstance() {

        if (instance == null) {
            instance = new CustomerService();
            instance.ensureTestData();
        }

        return instance;
    }

    /**
     * @return all available Customer objects.
     */
    public synchronized List<Customer> findAll() {
        return findAll(null);
    }

    /**
     * Finds all Customer's that match given filter.
     *
     * @param stringFilter
     *            filter that returned objects should match or null/empty string
     *            if all objects should be returned.
     * @return list a Customer objects
     */
    public synchronized List<Customer> findAll(String stringFilter) {

        ArrayList<Customer> arrayList = new ArrayList<>();

        for (Customer contact: contacts.values()) {
            try {
                boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                        || contact.toString().toLowerCase().contains(stringFilter.toLowerCase());

                if (passesFilter) {
                    arrayList.add(contact.clone());
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Collections.sort(arrayList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int) (o2.getId() - o1.getId());
            }
        });

        return arrayList;
    }

    private void ensureTestData() {
    }
}
