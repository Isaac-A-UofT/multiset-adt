import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
  // Private Attributes
  // The item stored at this tree's root, or null if the tree is empty.
  private Object root;

  // The list of all subtrees of this tree.
  private List<Tree<T>> subtrees;

  public Tree(T root) {
    this.root = root;
    this.subtrees = new ArrayList<>();
  }

  public Tree(T root, List<Tree<T>> subtrees) {
    this.root = root;
    this.subtrees = new ArrayList<>(subtrees);
  }

  public Object getRoot() {
    return root;
  }

  public List<Tree<T>> getSubtrees() {
    return subtrees;
  }

  public void setRoot(T root) {
    this.root = root;
  }

  public void setSubtrees(List<Tree<T>> subtrees) {
    this.subtrees = subtrees;
  }

  public boolean is_empty() {
    return (this.root == null);
  }

  public int count(T item) {
    if (this.is_empty()) {
      return 0;
    } else {
      int num = 0;
      if (this.root.equals(item)) {
        num += 1;
      }
      for (Tree<T> x : this.getSubtrees()) {
        num += x.count(item);
      }
      return num;
    }
  }

  public double average(){
    if(this.is_empty()){
      return 0.0;
    }
    double count = this.average_helper();
    int size = this.length();
    return count / size;

  }
  private double average_helper(){
    int total = 0;
    if(this.root != null ){
      total = total + this.root;
    }
    for(Tree<T> i: this.subtrees){
      total += this.average_helper();
    }
    return total;
  }
  @Override
  public boolean equals(Tree o) {

    if (this.is_empty() & o.is_empty()) {
      return true;
    } else if (this.is_empty() || o.is_empty()) {
      return false;
    } else {
      if (this.root != o.getRoot()) {
        return false;
      }
      if (this.subtrees.size() != o.subtrees.size()) {
        return false;
      }
      return this.subtrees == o.subtrees;
    }
  }
  public int length() {
    if (this.is_empty()) {
      return 0;
    } else {
      int size = 1;
      for (Tree<T> x : this.getSubtrees()) {
        size += x.length();
      }
      return size;
    }
  }

  public boolean contains(Object item) {
    if (this.is_empty()) {
      return false;
    }
    if (this.root == item) {
      return true;
    } else {
      for (Tree<T> i : this.subtrees) {
        return i.contains(item);
      }
      return false;
    }
  }

}




