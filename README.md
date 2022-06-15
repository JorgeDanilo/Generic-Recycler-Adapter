> ### Generic Recycler Adapter
> - Generic Adapter to be used in any project, avoiding boilerplate code.
> - Can be used even in complex layouts.

### How to Use ?

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        val genericAdapter =
            GenericRecyclerAdapter(initUsers(), R.layout.item_sample, setupItemAdapter())
        val recyclerView: RecyclerView = findViewById(R.id.rvItems)
        recyclerView.adapter = genericAdapter
    }

    private fun setupItemAdapter(): GenericRecyclerAdapterInterface<User> {
        return object : GenericRecyclerAdapterInterface<User> {
            override fun bindData(item: User, view: View) {
                val txtName: TextView = view.findViewById(R.id.txtName)
                val txtEmail: TextView = view.findViewById(R.id.txtEmail)

                txtName.text = item.name
                txtEmail.text = item.email
            }
        }
    }
    
    private fun initUsers(): List<User> {
        return listOf(
            User("Joaquim", "joaqui@gmail.com"),
            User("Silva", "silva@gmail.com"),
            User("Ricardo", "ricardo@gmail.com"),
            User("James", "james@gmail.com"),
            User("Goku", "Goku@gmail.com"),
            User("Vegeta", "vegeta@gmail.com"),
        )
    }
}
```

