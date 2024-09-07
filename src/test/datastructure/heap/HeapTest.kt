import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class HeapTest : BehaviorSpec(
    {

        Given("MaxHeap") {
            val heap: _root_ide_package_.datastructure.heap.Heap<Int> =
                _root_ide_package_.datastructure.heap.Heap { o1: Int, o2: Int -> o1 - o2 }
            And("with increasing Input") {
                val elements = (1..10)
                elements.forEach {
                    When("offer $it") {
                        heap.offer(it)
                        Then("peek should be $it") {
                            heap.peek() shouldBe it
                        }
                    }
                }
                for (i in 10 downTo 1) {
                    When("poll") {
                        val poll = heap.poll()
                        Then("poll should be $i") {
                            poll shouldBe i
                        }
                    }
                }
            }
            And("with decreasing Input") {
                val elements = (10 downTo 1)
                elements.forEach {
                    When("offer $it") {
                        heap.offer(it)
                        Then("peek should be 10") {
                            heap.peek() shouldBe 10
                        }
                    }
                }
                for (i in 10 downTo 1) {
                    When("poll") {
                        val poll = heap.poll()
                        Then("poll should be $i") {
                            poll shouldBe i
                        }
                    }
                }
            }
        }

        Given("MinHeap") {
            val heap: _root_ide_package_.datastructure.heap.Heap<Int> =
                _root_ide_package_.datastructure.heap.Heap { o1: Int, o2: Int -> o2 - o1 }
            And("with increasing Input") {
                val elements = (1..10)
                elements.forEach {
                    When("offer $it") {
                        heap.offer(it)
                        Then("peek should be 1") {
                            heap.peek() shouldBe 1
                        }
                    }
                }
                for (i in 1..10) {
                    When("poll") {
                        val poll = heap.poll()
                        Then("poll should be $i") {
                            poll shouldBe i
                        }
                    }
                }
            }
            And("with decreasing Input") {
                val elements = (10 downTo 1)
                elements.forEach {
                    When("offer $it") {
                        heap.offer(it)
                        Then("peek should be $it") {
                            heap.peek() shouldBe it
                        }
                    }
                }
                for (i in 1..10) {
                    When("poll") {
                        val poll = heap.poll()
                        Then("poll should be $i") {
                            poll shouldBe i
                        }
                    }
                }
            }
        }
    },
)
