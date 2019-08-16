/**
 * Copyright (C), 2015-2019
 * FileName: MergeTwoLists
 * Author:   luo.yongqian
 * Date:     2019/7/31 17:54
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2019/7/31 17:54      1.0.0               创建
 */
package com.roboslyq.algorithm.leetcode.lc0001to0100.lc0021_mergetwolists;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @create 2019/7/31
 * @since 1.0.0
 *
 */
/**
 * Definition for singly-linked list.

 */
public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode result = mergeTwoLists.mergeTwoLists(l1,l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }

    /**
     * 通过变量，消除重复代码
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode result = new ListNode(0);//结果保存，返回时取result.next()
        ListNode calResult = result;
        ListNode currentNode = l1;
        ListNode backNode =l2;
        while (currentNode != null && backNode != null){
            if(currentNode.val > backNode.val){
                ListNode tmp = currentNode;
                currentNode = backNode;
                backNode = tmp;
            }
            calResult.next = new ListNode(currentNode.val);
            currentNode = currentNode.next;
            if(currentNode == null){
                calResult.next.next = backNode;
                break;
            }
            calResult = calResult.next;

        }
        return result.next;

    }

    /**
     * 另一种写法，通过if判断，有部分重复代码
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode result = new ListNode(0);//结果保存，返回时取result.next()
        ListNode calResult = result;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                calResult.next = new ListNode(l1.val);
                l1 = l1.next;
                if(l1 == null){
                    calResult.next.next = l2;
                    break;
                }
            }else{
                calResult.next = new ListNode(l2.val);
                l2 = l2.next;
                if(l2 == null){
                    calResult.next.next = l1;
                    break;
                }
            }
            calResult = calResult.next;

        }
        return result.next;
    }

}

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
 }