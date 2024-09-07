package problemsolving.leetcode.datastructure

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ListNodeTest : BehaviorSpec(
    {

        Given("elements: []") {
            val elements: Array<Int> = arrayOf()
            When("ListNode.generate is called with input") {
                val generatedListNode = ListNode.generate(elements)
                Then("return should be ListNode of null") {
                    generatedListNode shouldBe null
                }
            }
        }

        Given("elements: [1]") {
            val elements: Array<Int> = arrayOf(1)
            When("ListNode.generate is called with input") {
                val generatedListNode = ListNode.generate(elements)
                Then("return should be ListNode of 1") {
                    generatedListNode.`val` shouldBe 1
                    generatedListNode.next shouldBe null
                }
            }
        }

        Given("elements: [1, 2, 3, 4, 5]") {
            val elements: Array<Int> = arrayOf(1, 2, 3, 4, 5)
            When("ListNode.generate is called with input") {
                val generatedListNode = ListNode.generate(elements)
                Then("return should be ListNode of 1 -> 2 -> 3 -> 4 -> 5") {
                    generatedListNode.`val` shouldBe 1
                    generatedListNode.next.`val` shouldBe 2
                    generatedListNode.next?.next?.`val` shouldBe 3
                    generatedListNode.next?.next?.next?.`val` shouldBe 4
                    generatedListNode.next?.next?.next?.next?.`val` shouldBe 5
                    generatedListNode.next?.next?.next?.next?.next shouldBe null
                }
            }
        }

    },
)
