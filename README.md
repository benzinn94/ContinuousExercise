Software Engineering (C-T-303-HUGB), Week 10 Fall Semester 2017

# Continuous Integration with Travis & Heroku
## This repo
Status: \<Add Travis Status Badge\>

Is a very simple Spark Web application, built with Gradle.

* To run `gradle run`
* To create a deployable package:
    * `gradle installDist`
    * This creates an executable in `build/install/<NAME-OF-PROJECT>/bin`, both a shell file and a bat file that can be run.
* To run tests `gradle test`

### Running
Once running, head over to [localhost:4567](http://localhost:4567) and witness the magic.

## Objectives
The objective is that the students experiment with setting up a continuous integration pipeline; from a code change to running tests automatically and getting feedback. In addition deploying a working artifact to a staging-like environment is a logical next step.

## Assignment
### 1. Setup Travis CI for a repo
1. Fork the calcApi repository: [github.com/arnlaugsson/stringCalcWeb](https://github.com/arnlaugsson/stringCalcWeb)
    * Note: since this is a public repo, you can't fork is as a private repo (directly at least).
2. Go to [Travis-ci.org](https://travis-ci.org/)
    1. Sign in with GitHub
    2. Give GitHub access to this repository (note you might need to "sync" repos to Travis CI, using a button).
3. Clone the repo to your local environment and make the following changes:
    1. Create a `.travis.yml` file in the root of the project. If you are unsure about what to put in this file, or what it is used for, go read a bit on Java projects in Travis CI, [docs.travis-ci.com/](http://docs.travis-ci.com/user/languages/java/).
    2. Add the new file, but don't commit yet.
    3. Add a build badge into the top of a README.md file
        * This should be something like: `[![Build Status](your travis url for the repo here.png)](your travis url for the repo here)`
        * Add some information to the README file.
    4. Add the new README.md, commit and push.
4. If everything went OK, you should see something happening. In Github (the badge) and on Travis CI.

### 2. Deploy to a Heroku server
Heroku offers a great step-by-step introduction for deploying Gradle applications on Heroku, if you get stuck somewhere, head over there to check that out.

[Deploying Gradle apps on Heroku](https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku)


1. Sign up for free on [Heroku.com](https://www.heroku.com/).
2. Setup the [Heroku Toolbelt](https://toolbelt.heroku.com/)
3. Sign in using the Heroku Toolbelt
4. Using the same repo as in the first part of the assignment; in the root, create a new Heroku app: `heroku apps:create`
5. Take a look at the [Getting started with Gradle on Heroku guide](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku#introduction)
6. Add a `stage` task to your build.gradle file, and add a Procfile, similar to the one given in the Getting started guide.
7. Commit and push to Heroku: `git commit -m "Added Heroku Procfile"; git push heroku master`
8. You should now have a running application somewhere on herokuapp.


### 3. Putting Travis CI & Heroku together
Disclaimer: This is where things get tricker, and we'll only help move you in the right direction.

To move from a simple Continuous integration cycle, to something more complicated continuous delivery, you will need to define a staging server. This can easily be a Heroku app server. How would you go about setting the following up:

1. Code changes are made to a feature branch as a part of a pull request
2. Travis runs all unit and integration tests on commit and push to GitHub
    * If there are failures, GitHub would show this on the pull request.
    * If the tests pass and other checks pass
        1. Travis CI will deploy the application to a staging server.
        2. That can be used for manual testing, or later some functional tests like Selenium tests.

You will need:

1. A basic understanding of how Heroku and Travis can communicate: [http://docs.travis-ci.com/user/deployment/heroku/](http://docs.travis-ci.com/user/deployment/heroku/)
2. Travis command line tools: [https://github.com/travis-ci/travis.rb](https://github.com/travis-ci/travis.rb)




