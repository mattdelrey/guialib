# ¡Guia Lib!

This is my submission for the ¡Guia Lib! code challenge. This took about 2 hours.


## Architecture Considerations

### Compose
My thought process for using Compose is simply because I think it's cleaner, quicker, and easier to write than the old xml view system. I don't have professional experience using Compose on my resume, so I wanted to show that not only can I write in Compose, I'm more comfortable using it. Most of my experience using Compose comes from a personal project I've been working on with a friend that's an app that helps facilitate the songwriting process for bands. Overall, the UI for Guia Lib is pretty quick and dirty as you will see when viewing the app. If I had more time, I would certainly finesse a lot with the design.

### MVVM

My overall approach to MVVM is pretty straightfoward. I would like to call out that I am also using the Use Case pattern that is recommended by Google (See https://developer.android.com/topic/architecture/domain-layer). I think this is a great way of abstracting a lot of your business logic when working in viewmodels and also encourages code reuse.

### Hilt/Dagger

I used this for easy DI. Not only is it ideal for most android projects, it also makes injecting viewmodels into Compose very straightforward.

### Retrofit

I chose this because I've used it in pretty much every project I've worked on since 2015 with the exception of my personal project which uses Cloud Firestore.

### Coroutines

This is a must at this point if you want easy thread handling and clean code.

### Product Flavors

To support a separate Build A and Build B, I added two different product flavors. There's a separate strings.xml in each resource folder in the corresponding build which contains the copy to show at the top of the app.

## If I Had More Time...

### Testing

I was unable to get to the testing part of the coding challenges. There's just not enough time. A lot of the setup with different libraries easily eats into the 2 hours alloted as well considering I ran into several configuration and library issues (which I believe is pretty normal). I don't regret adding the libraries because they demonstrate my ideal approach to how an app should be written. Regarding tests, if I had more time, my strategy is to start with writing unit tests for business logic only. This means I would test with logic in the viewmodel, the use cases, and repos. A more holistic approach would also involve automated UI tests (preferably with Espresso).

### Design
This app is UGLY looking! I would take a lot more time to get the spacing right and figure out font sizes that are more user friendly. I would add iconography to help users more easily identify things like the date and venue. And of course, I would probably show the iconUrl using a third party library like Glide.

### Error Handling
There's no real handling here. I would include a snackbar error if it fails to load. Also, I would also change the UX so there's a pull to refresh or some way of refreshing the result list in case there is an error.

### Caching Results

I would cache the network results in Guides Repo using a DB with Room. That way, if the results fail to load, we can always load what we have in our DB. This also would introduce offline support.

### Navigation

Right now, I'm just showing the Guides Screen baked into our MainActivity. Most apps would have some type of navigation (preferrably with Jetpack).

### API Cleanup

There's lots that could be tweaked with the API. For example, it doesn't support Dates. Instead, start and end date are both raw strings that are coming from the backend and aren't localized. Also, there's no id on each Guide in the API, so there's no way to guarantee uniqueness.