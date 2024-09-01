package problemsolving.leetcode.datastructure

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class N_Ary_NodeTest : BehaviorSpec({

    Given("elements: [1, null, 3, 2, 4, null, 5, 6]") {
        val elements: Array<Int?> = arrayOf(1, null, 3, 2, 4, null, 5, 6)
        When("N_Ary_Node.generate is called with input") {
            val generatedN_Ary_Node = N_Ary_Node.generate(elements)
            Then("return should be N_Ary_Node") {
                // depth 0
                generatedN_Ary_Node.`val` shouldBe 1

                // depth 1
                generatedN_Ary_Node.children.size shouldBe 3
                generatedN_Ary_Node.children[0].`val` shouldBe 3
                generatedN_Ary_Node.children[1].`val` shouldBe 2
                generatedN_Ary_Node.children[2].`val` shouldBe 4

                // depth 2
                generatedN_Ary_Node.children[0].children.size shouldBe 2
                generatedN_Ary_Node.children[0].children[0].`val` shouldBe 5
                generatedN_Ary_Node.children[0].children[1].`val` shouldBe 6

                generatedN_Ary_Node.children[1].children.size shouldBe 0

                generatedN_Ary_Node.children[2].children.size shouldBe 0

                // depth 3
                generatedN_Ary_Node.children[0].children[0].children.size shouldBe 0

                generatedN_Ary_Node.children[0].children[1].children.size shouldBe 0
            }
        }
    }

    Given("elements: [1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14]") {
        val elements: Array<Int?> = arrayOf(
            1,
            null,
            2,
            3,
            4,
            5,
            null,
            null,
            6,
            7,
            null,
            8,
            null,
            9,
            10,
            null,
            null,
            11,
            null,
            12,
            null,
            13,
            null,
            null,
            14
        )
        When("N_Ary_Node.generate is called with input") {
            val generatedN_Ary_Node = N_Ary_Node.generate(elements)
            Then("return should be N_Ary_Node") {
                // depth 0
                generatedN_Ary_Node.`val` shouldBe 1

                // depth 1
                generatedN_Ary_Node.children.size shouldBe 4
                generatedN_Ary_Node.children[0].`val` shouldBe 2
                generatedN_Ary_Node.children[1].`val` shouldBe 3
                generatedN_Ary_Node.children[2].`val` shouldBe 4
                generatedN_Ary_Node.children[3].`val` shouldBe 5

                // depth 2
                generatedN_Ary_Node.children[0].children.size shouldBe 0

                generatedN_Ary_Node.children[1].children.size shouldBe 2
                generatedN_Ary_Node.children[1].children[0].`val` shouldBe 6
                generatedN_Ary_Node.children[1].children[1].`val` shouldBe 7

                generatedN_Ary_Node.children[2].children.size shouldBe 1
                generatedN_Ary_Node.children[2].children[0].`val` shouldBe 8

                generatedN_Ary_Node.children[3].children.size shouldBe 2
                generatedN_Ary_Node.children[3].children[0].`val` shouldBe 9
                generatedN_Ary_Node.children[3].children[1].`val` shouldBe 10

                // depth 3
                generatedN_Ary_Node.children[1].children[0].children.size shouldBe 0

                generatedN_Ary_Node.children[1].children[1].children.size shouldBe 1
                generatedN_Ary_Node.children[1].children[1].children[0].`val` shouldBe 11

                generatedN_Ary_Node.children[2].children[0].children.size shouldBe 1
                generatedN_Ary_Node.children[2].children[0].children[0].`val` shouldBe 12

                generatedN_Ary_Node.children[3].children[0].children.size shouldBe 1
                generatedN_Ary_Node.children[3].children[0].children[0].`val` shouldBe 13

                generatedN_Ary_Node.children[3].children[1].children.size shouldBe 0

                // depth 4
                generatedN_Ary_Node.children[1].children[1].children[0].children.size shouldBe 1
                generatedN_Ary_Node.children[1].children[1].children[0].children[0].`val` shouldBe 14

                generatedN_Ary_Node.children[2].children[0].children[0].children.size shouldBe 0

                generatedN_Ary_Node.children[3].children[0].children[0].children.size shouldBe 0
            }
        }
    }
})
