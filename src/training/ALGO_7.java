package training;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ��
 *
 */
public class ALGO_7 {

    /**
���裺
��1��f(root)��ʾ��rootΪ���Ķ����������������
��2��revPair(list1, list2)��ʾ����list1������list2������Ը���������
list1 = 2->1->4, list2 = 1->2->3����list1��list2���������(2,1),(4,1),(4,2)��(4,3)�����ʱrevPair(list1, list2) = 4
��3��list(root)��ʾ��rootΪ���Ķ�������Ҷ�ӽڵ�������������γɵ����������Ѿ�������
���У�
��1�����root��Ҷ�ӽڵ㣬��f(root) = 0����Ȼû�������
��2�����root����Ҷ�ӽڵ㣬��������״̬ת�Ʒ���
f(root) = f(root->left) + f(root->right) + 
          min(revPair(list(root->left), list(root->right)),//�������������� 
              revPair(list(root->right), list(root->left)))//������������
     */
    private static int leafNum;
    private static int[] weightArr;
    private static NPoint tree;
    private static int i=0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        init();
        int minRev=f(tree);
        System.out.println(minRev);
    }

    private static int f(NPoint root){
        if(root.weight!=0){//�ýڵ�ΪҶ�ӽڵ�
            return 0;
        }else{//�ýڵ㲻��Ҷ�ӽڵ�
            ArrayList<Integer> listLeft=new ArrayList<Integer>();
            ArrayList<Integer> listRight=new ArrayList<Integer>();
            list(root.left,listLeft);
            list(root.right,listRight);
            return f(root.left) + f(root.right)+Math.min(revPair(listLeft, listRight),//�������������� 
                      revPair(listRight, listLeft));//������������
        }
    }

    private static int revPair(ArrayList<Integer> list1,ArrayList<Integer> list2){
        int count=0;
        for (int i = 0; i < list1.size(); i++) {
        	for (int j = 0; j < list2.size(); j++) {
        		if (list1.get(i) > list2.get(j)) {
        			count++;
        		}
        	}
        }
        return count;
    }

    private static void list(NPoint p,ArrayList<Integer> li){
        if(p.weight!=0){//�ýڵ�ΪҶ�ӽڵ�
            li.add(p.weight);
        }else{
            list(p.left,li);
            list(p.right,li);
        }
    }

    private static void init(){
        Scanner sc=new Scanner(System.in);
        leafNum=sc.nextInt();
        weightArr=new int[2*leafNum-1];
        for(int i=0;i<2*leafNum-1;i++){
            weightArr[i]=sc.nextInt();
        }
        tree=new NPoint();
        tree.weight=weightArr[i++];
        getTree(tree);
        sc.close();
    }

    private static void getTree(NPoint p){
        if(weightArr[i]==0){
            p.left=new NPoint();
            p.right=new NPoint();
            p.weight=weightArr[i++];
            getTree(p.left);
            getTree(p.right);
        }else{
            p.weight=weightArr[i++];
            p.left=null;
            p.right=null;
        }
    }
}

class NPoint{
    NPoint left;
    NPoint right;
    int weight;
}