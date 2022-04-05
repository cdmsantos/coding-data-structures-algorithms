package com.crystalsantos.coding.amazon.treesandgraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Course Schedule
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1. Return true if you can finish all courses. Otherwise,
 * return false.
 * 
 * Example 1:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]] Output: true Explanation:
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible. Example 2:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]] Output: false
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * 
 * Constraints:
 * 
 * 1 <= numCourses <= 105 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2 0 <= ai, bi < numCourses All the pairs
 * prerequisites[i] are unique.
 * 
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// course -> list of next courses
		HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

		// build the graph first
		for (int[] relation : prerequisites) {
			// relation[0] depends on relation[1]
			if (courseDict.containsKey(relation[1])) {
				courseDict.get(relation[1]).add(relation[0]);
			} else {
				List<Integer> nextCourses = new LinkedList<>();
				nextCourses.add(relation[0]);
				courseDict.put(relation[1], nextCourses);
			}
		}

		boolean[] checked = new boolean[numCourses];
		boolean[] path = new boolean[numCourses];

		for (int i = 0; i < numCourses; ++i) {
			if (isCyclic(i, courseDict, checked, path)) {
				return false;
			}
		}

		return true;
	}

	/*
	 * postorder DFS check that no cycle would be formed starting from currCourse
	 */
	protected boolean isCyclic(Integer currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] checked,
			boolean[] path) {

		// bottom cases
		if (checked[currCourse]) {
			// this node has been checked, no cycle would be formed with this node.
			return false;
		}

		if (path[currCourse]) {
			// come across a previously visited node, i.e. detect the cycle
			return true;
		}

		// no following courses, no loop.
		if (!courseDict.containsKey(currCourse)) {
			return false;
		}

		// before backtracking, mark the node in the path
		path[currCourse] = true;

		boolean ret = false;
		// postorder DFS, to visit all its children first.
		for (Integer child : courseDict.get(currCourse)) {
			ret = isCyclic(child, courseDict, checked, path);
			if (ret) {
				break;
			}
		}

		// after the visits of children, we come back to process the node itself
		// remove the node from the path
		path[currCourse] = false;

		// Now that we've visited the nodes in the downstream,
		// we complete the check of this node.
		checked[currCourse] = true;
		return ret;
	}

	public static void main(String[] args) {
		CourseSchedule courses = new CourseSchedule();

		System.out.println(courses.canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(courses.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}
}
