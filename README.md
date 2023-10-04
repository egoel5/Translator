# Translator

This program takes text from English, Spanish, German, or it can even detect a source language, and then translates it into either English, German, or Spanish. It does the translation in real-time, eliminating the need for a button.

## Functionality 

The following **required** functionality is completed:

* [✅] User sees 4 options to choose a source language and 3 options to choose a target language.
* [✅] User can translate text from over 100 languages in real-time.
* [✅] Implemented text change listener
* [✅] Initialized the view model

The following **extensions** are implemented:

* Detect Language is added for bonus

## Video Walkthrough

Here's a walkthrough of implemented user stories:

![](https://github.com/egoel5/C323_Project5/blob/master/Project%205%20Video%20Walkthrough.gif)

GIF created with [Adobe Express](https://new.express.adobe.com).

## Notes

The only challenge I had with this app is that when I tried to do the detect language function, I was having trouble using the languageCode to find the correct sourceLanguage. I figured out that all I needed was a toString() call at the end.

## License

    Copyright [2023] [Eshan Goel]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
