

- Extension functions:
 
    - Example
    ```kotlin
    // filename StringExtensions
    package ro.jtonic.coursera.extensions
    fun String.lastChar() = this[this.length - 1]
    ```
    - String is the receiver of the ext function
    - The receiver can be referenced as this (and it also can be omitted)
    - It compiles to a static method in java with an additional first argument - the receiver
    - Can be called from Java as a static method
    - In order to be used in another kotlin class the FQN of the ext function has to be imported
    ```kotlin
    import ro.jtonic.coursera.extensions.StringExtensionsKt.lastChar
    ```
    - limitations:
        - private members of the receiver cannot be called from extension functions
        

    
