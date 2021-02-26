# modular-dialog-fragment-design
Sample project that displays a dialog fragment which shows communication between activity and fragment using  shared viewmodel

## BaseDialogFragment
this class contains skeletal code for getting ViewModel
- ViewModel is created according to the scope of parent using
```
    private fun viewModelOfActivityOrFragment(): DialogViewModel {
        return if (parentFragment != null) {
            ViewModelProvider(requireParentFragment()).get(DialogViewModel::class.java)
        } else {
            ViewModelProvider(requireActivity()).get(DialogViewModel::class.java)
        }
    }
```

## Applying properties to Dialog

In Activity, get the `DialogViewModel` using `ViewModelProvider`
```
        val dialogVM = ViewModelProvider(this@MainActivity).get(DialogViewModel::class.java)
        // apply properties
        with(dialogVM) {
            dialogTitle.value = "sample title"
            dialogDescription.value = "sample description"
            confirmClickListener = {..doStuff}
            cancelClickListener = {..doStuff}
            dismissClickListener = {..doStuff}
        }

```

In Fragments, get the `DialogViewModel` using `ViewModelProvider`
```
        val dialogVM = ViewModelProvider(this@SampleFragment).get(DialogViewModel::class.java)
        // apply properties
        with(dialogVM) {
            dialogTitle.value = "sample title"
            dialogDescription.value = "sample description"
            confirmClickListener = {..doStuff}
            cancelClickListener = {..doStuff}
            dismissClickListener = {..doStuff}
        }

```

## License
```
    Copyright [2020] [Chetan gupta] [chetangupta.net]
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 ```
