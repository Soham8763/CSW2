package Assignment6.q4;

class Country {
    private String name;
    private long population;

    public Country(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + " (Population: " + population + ")";
    }
}

class BNode {
    Country country;
    BNode left;
    BNode right;

    public BNode(Country country) {
        this.country = country;
        this.left = null;
        this.right = null;
    }
}

class BSTCountry {
    private BNode root;

    public BSTCountry() {
        this.root = null;
    }

    public void insert(Country country) {
        root = insertHelper(root, country);
    }

    private BNode insertHelper(BNode node, Country country) {
        if (node == null) {
            return new BNode(country);
        }

        if (country.getPopulation() < node.country.getPopulation()) {
            node.left = insertHelper(node.left, country);
        } else if (country.getPopulation() > node.country.getPopulation()) {
            node.right = insertHelper(node.right, country);
        }

        return node;
    }

    public void inorderTraversal() {
        inorderTraversalHelper(root);
    }

    private void inorderTraversalHelper(BNode node) {
        if (node != null) {
            inorderTraversalHelper(node.left);
            System.out.println(node.country);
            inorderTraversalHelper(node.right);
        }
    }

    public Country findMax() {
        if (root == null) {
            return null;
        }
        BNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.country;
    }

    public Country findMin() {
        if (root == null) {
            return null;
        }
        BNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.country;
    }
}

public class q4 {
    public static void main(String[] args) {
        BSTCountry bst = new BSTCountry();

        bst.insert(new Country("India", 1428627663));
        bst.insert(new Country("China", 1425671352));
        bst.insert(new Country("United States", 339996563));
        bst.insert(new Country("Indonesia", 277534122));
        bst.insert(new Country("Pakistan", 240485658));

        System.out.println("Countries sorted by population (in-order traversal):");
        bst.inorderTraversal();

        System.out.println("\nCountry with maximum population:");
        System.out.println(bst.findMax());

        System.out.println("\nCountry with minimum population:");
        System.out.println(bst.findMin());
    }
}