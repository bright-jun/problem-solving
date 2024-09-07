package problemsolving.leetcode.datastructure

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TreeNodeTest : BehaviorSpec(
    {

        Given("elements: []") {
            val elements: Array<Int> = arrayOf()
            When("TreeNode.generate is called with input") {
                val generatedTreeNode = TreeNode.generate(elements)
                Then("return should be TreeNode of null") {
                    generatedTreeNode shouldBe null
                }
            }
        }

        Given("elements: [1]") {
            val elements: Array<Int> = arrayOf(1)
            When("TreeNode.generate is called with input") {
                val generatedTreeNode = ListNode.generate(elements)
                Then("return should be TreeNode of 1") {
                    generatedTreeNode.`val` shouldBe 1
                    generatedTreeNode.next shouldBe null
                }
            }
        }

        Given("elements: [1, 2, 3, 4, 5, 6, 7]") {
            val elements: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7)
            When("TreeNode.generate is called with input") {
                val generatedTreeNode = TreeNode.generate(elements)
                Then("return should be TreeNode of 12345") {
                    // 1 depth
                    generatedTreeNode.`val` shouldBe 1

                    // 2 depth
                    generatedTreeNode.left.`val` shouldBe 2
                    generatedTreeNode.right.`val` shouldBe 3

                    // 3 depth
                    generatedTreeNode.left.left.`val` shouldBe 4
                    generatedTreeNode.left.right.`val` shouldBe 5
                    generatedTreeNode.right.left.`val` shouldBe 6
                    generatedTreeNode.right.right.`val` shouldBe 7
                }
            }
        }

        Given("elements: [1, 2, null, null, 5, null, null]") {
            val elements: Array<Int?> = arrayOf(1, 2, null, null, 5, null, null)
            When("TreeNode.generate is called with input") {
                val generatedTreeNode = TreeNode.generate(elements)
                Then("return should be TreeNode of 125") {
                    // 1 depth
                    generatedTreeNode.`val` shouldBe 1

                    // 2 depth
                    generatedTreeNode.left.`val` shouldBe 2
                    generatedTreeNode.right shouldBe null

                    // 3 depth
                    generatedTreeNode.left.left shouldBe null
                    generatedTreeNode.left.right.`val` shouldBe 5
                }
            }
        }
    },
)
