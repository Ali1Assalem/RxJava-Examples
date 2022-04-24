package com.example.threadstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doOnTextChanged
import com.example.threadstest.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    /**
    @auther Ali_Assalem
    4/23/2022
    */

    lateinit var binding:ActivityMainBinding

    lateinit var disposable: Disposable
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rx()
    }

    private fun rx(){
//        val observable=Observable.just(5,7,8,4)

//        val observer= object : Observer<Int> {
//            override fun onSubscribe(d: Disposable?) {
//                Log.i("ALI","on Subscribe")
//            }
//            override fun onNext(t: Int?) {
//                Log.i("ALI","on next : $t")
//            }
//            override fun onError(e: Throwable?) {
//                Log.i("ALI","on Error")
//            }
//            override fun onComplete() {
//                Log.i("ALI","on Complete")
//            }
//        }

    //       observable.subscribe(observer)

        //        observable.subscribe(
//            {
//                t-> Log.i("ALI","on next : $t")
//            },{
//                e-> Log.i("ALI","on Error")
//            }
//        )

//        2022-04-23 17:25:54.801 28930-28930/com.example.threadstest I/ALI: on Subscribe
//        2022-04-23 17:25:54.802 28930-28930/com.example.threadstest I/ALI: on next : 5
//        2022-04-23 17:25:54.802 28930-28930/com.example.threadstest I/ALI: on next : 7
//        2022-04-23 17:25:54.802 28930-28930/com.example.threadstest I/ALI: on next : 8
//        2022-04-23 17:25:54.802 28930-28930/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 17:25:54.802 28930-28930/com.example.threadstest I/ALI: on Complete


                  //___________________________________________________________________________________________________________//

//        val observable=Observable.fromArray(1,2,3,4,5,6,7,8,9,10,11,12)
//        observable.subscribe(
//            {
//                t-> Log.i("ALI","on next : $t")
//            },{
//                e-> Log.i("ALI","on Error")
//            }
//        )


//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 3
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 5
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 6
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 7
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 8
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 9
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 10
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 11
//        2022-04-23 17:41:47.121 935-935/com.example.threadstest I/ALI: on next : 12

        //___________________________________________________________________________________________________________//


//        val list= listOf(1,2,3,4,5,6,7,8,9,10,11,12)
//        val observable=Observable.fromIterable(list)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )

//        2022-04-23 17:46:06.048 3637-3637/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 3
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 5
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 6
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 7
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 8
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 9
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 10
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 11
//        2022-04-23 17:46:06.049 3637-3637/com.example.threadstest I/ALI: on next : 12

        //___________________________________________________________________________________________________________//


//        val list= listOf(1,2)
//        val observable=Observable.fromIterable(list).repeat(3)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )

//        2022-04-23 17:48:43.342 6572-6572/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 17:48:43.342 6572-6572/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 17:48:43.342 6572-6572/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 17:48:43.342 6572-6572/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 17:48:43.342 6572-6572/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 17:48:43.342 6572-6572/com.example.threadstest I/ALI: on next : 2

        //___________________________________________________________________________________________________________//


//        val observable=Observable.range(3,8)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//
//        2022-04-23 17:52:40.402 9151-9151/com.example.threadstest I/ALI: on next : 3
//        2022-04-23 17:52:40.402 9151-9151/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 17:52:40.403 9151-9151/com.example.threadstest I/ALI: on next : 5
//        2022-04-23 17:52:40.403 9151-9151/com.example.threadstest I/ALI: on next : 6
//        2022-04-23 17:52:40.403 9151-9151/com.example.threadstest I/ALI: on next : 7
//        2022-04-23 17:52:40.403 9151-9151/com.example.threadstest I/ALI: on next : 8
//        2022-04-23 17:52:40.403 9151-9151/com.example.threadstest I/ALI: on next : 9
//        2022-04-23 17:52:40.403 9151-9151/com.example.threadstest I/ALI: on next : 10

        //___________________________________________________________________________________________________________//


//        val observable=Observable.interval(3,TimeUnit.SECONDS)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )

//        val observable=Observable.interval(1,TimeUnit.SECONDS).take(4)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//
//        2022-04-23 17:59:35.102 11797-11861/com.example.threadstest I/ALI: on next : 0
//        2022-04-23 17:59:36.102 11797-11861/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 17:59:37.102 11797-11861/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 17:59:38.102 11797-11861/com.example.threadstest I/ALI: on next : 3

        //___________________________________________________________________________________________________________//


//        val observable=Observable.interval(1,TimeUnit.SECONDS).take(4,TimeUnit.SECONDS)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 18:00:55.262 13112-13181/com.example.threadstest I/ALI: on next : 0
//        2022-04-23 18:00:56.262 13112-13181/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 18:00:57.262 13112-13181/com.example.threadstest I/ALI: on next : 2

//        val observable=Observable.range(1,1000).takeLast(3)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 18:13:28.110 22244-22244/com.example.threadstest I/ALI: on next : 998
//        2022-04-23 18:13:28.110 22244-22244/com.example.threadstest I/ALI: on next : 999
//        2022-04-23 18:13:28.110 22244-22244/com.example.threadstest I/ALI: on next : 1000


        //___________________________________________________________________________________________________________//



//        val observable=Observable.range(1,5).skip(2)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//
//        2022-04-23 18:17:56.555 26415-26415/com.example.threadstest I/ALI: on next : 3
//        2022-04-23 18:17:56.556 26415-26415/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 18:17:56.556 26415-26415/com.example.threadstest I/ALI: on next : 5

//        val observable=Observable.timer(5,TimeUnit.SECONDS)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )

        //___________________________________________________________________________________________________________//


//        val list= listOf(1,2,2,3,3,4,2,2,3)
//        val observable=Observable.fromIterable(list).distinct()
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//
//        2022-04-23 18:24:09.182 28748-28748/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 18:24:09.182 28748-28748/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 18:24:09.182 28748-28748/com.example.threadstest I/ALI: on next : 3
//        2022-04-23 18:24:09.183 28748-28748/com.example.threadstest I/ALI: on next : 4

        //___________________________________________________________________________________________________________//



//        val list= listOf(2,3,4,5,6,7,8,9)
//        val observable=Observable.fromIterable(list).buffer(3)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 18:28:40.206 30140-30140/com.example.threadstest I/ALI: on next : [2, 3, 4]
//        2022-04-23 18:28:40.207 30140-30140/com.example.threadstest I/ALI: on next : [5, 6, 7]
//        2022-04-23 18:28:40.207 30140-30140/com.example.threadstest I/ALI: on next : [8, 9]

        //___________________________________________________________________________________________________________//



//        val observable=Observable.range(1,4).map { it * 4 }
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 18:34:07.911 31725-31725/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 18:34:07.911 31725-31725/com.example.threadstest I/ALI: on next : 8
//        2022-04-23 18:34:07.911 31725-31725/com.example.threadstest I/ALI: on next : 12
//        2022-04-23 18:34:07.911 31725-31725/com.example.threadstest I/ALI: on next : 16

        //___________________________________________________________________________________________________________//


//        val someObservable=Observable.interval(500,TimeUnit.SECONDS).map { it * 4 }
//        val observable=Observable.interval(1,TimeUnit.SECONDS).map { it * 2 }.concatWith(someObservable)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//
//        2022-04-23 18:37:37.103 678-769/com.example.threadstest I/ALI: on next : 0
//        2022-04-23 18:37:38.103 678-769/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 18:37:39.103 678-769/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 18:37:40.103 678-769/com.example.threadstest I/ALI: on next : 6
//        2022-04-23 18:37:41.104 678-769/com.example.threadstest I/ALI: on next : 8
//        2022-04-23 18:37:42.104 678-769/com.example.threadstest I/ALI: on next : 10
//        2022-04-23 18:37:43.103 678-769/com.example.threadstest I/ALI: on next : 12
//        2022-04-23 18:37:44.103 678-769/com.example.threadstest I/ALI: on next : 14
//        2022-04-23 18:37:45.104 678-769/com.example.threadstest I/ALI: on next : 16

        //___________________________________________________________________________________________________________//


//        val someObservable=Observable.interval(200,TimeUnit.MILLISECONDS).map { it*100 }.take(5)
//        val observable=Observable.interval(1,TimeUnit.SECONDS).map { it*2 }.take(5).mergeWith(someObservable)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 18:47:39.544 10933-11023/com.example.threadstest I/ALI: on next : 0
//        2022-04-23 18:47:39.731 10933-11023/com.example.threadstest I/ALI: on next : 100
//        2022-04-23 18:47:39.931 10933-11023/com.example.threadstest I/ALI: on next : 200
//        2022-04-23 18:47:40.131 10933-11023/com.example.threadstest I/ALI: on next : 300
//        2022-04-23 18:47:40.330 10933-11022/com.example.threadstest I/ALI: on next : 0
//        2022-04-23 18:47:40.331 10933-11023/com.example.threadstest I/ALI: on next : 400
//        2022-04-23 18:47:41.330 10933-11022/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 18:47:42.330 10933-11022/com.example.threadstest I/ALI: on next : 4
//        2022-04-23 18:47:43.330 10933-11022/com.example.threadstest I/ALI: on next : 6
//        2022-04-23 18:47:44.330 10933-11022/com.example.threadstest I/ALI: on next : 8

        //___________________________________________________________________________________________________________//


//        val someObservable=Observable.interval(500,TimeUnit.MILLISECONDS).map { it*100 }.take(5)
//        val observable=Observable.interval(1,TimeUnit.SECONDS).map { it*2 }.take(5).zipWith(someObservable,
//            {l1,l2 ->
//                "$l1&$l2"
//            })
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 18:55:23.362 12327-12408/com.example.threadstest I/ALI: on next : 0&0
//        2022-04-23 18:55:24.362 12327-12408/com.example.threadstest I/ALI: on next : 2&100
//        2022-04-23 18:55:25.362 12327-12408/com.example.threadstest I/ALI: on next : 4&200
//        2022-04-23 18:55:26.361 12327-12408/com.example.threadstest I/ALI: on next : 6&300
//        2022-04-23 18:55:27.361 12327-12408/com.example.threadstest I/ALI: on next : 8&400


        //___________________________________________________________________________________________________________//


//        val observable=Observable.just(1,2,3).flatMap {
//            Observable.range(1,it)
//        }
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 19:00:02.670 13818-13818/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 19:00:02.671 13818-13818/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 19:00:02.671 13818-13818/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 19:00:02.671 13818-13818/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 19:00:02.671 13818-13818/com.example.threadstest I/ALI: on next : 2
//        2022-04-23 19:00:02.671 13818-13818/com.example.threadstest I/ALI: on next : 3

        //___________________________________________________________________________________________________________//


//        val observable=Observable.create<String>{ emmiter ->
//            binding.textInput.doOnTextChanged { text, start, before, count ->
//                emmiter.onNext(text.toString())
//            }
//        }//it is observable emmiter so i can changed name to emmiter
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//
//        if enter in edit text "hadi":
//        2022-04-23 20:30:45.223 28182-28182/com.example.threadstest I/ALI: on next : h
//        2022-04-23 20:30:46.833 28182-28182/com.example.threadstest I/ALI: on next : ha
//        2022-04-23 20:30:47.023 28182-28182/com.example.threadstest I/ALI: on next : had
//        2022-04-23 20:30:48.688 28182-28182/com.example.threadstest I/ALI: on next : hadi


        //___________________________________________________________________________________________________________//


//        val observable=Observable.create<String>{ emmiter ->
//            binding.textInput.doOnTextChanged { text, start, before, count ->
//                emmiter.onNext(text.toString())
//            }
//        }.take(2)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","on next : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
        //  "1234567890"
//        2022-04-23 20:37:49.239 32043-32043/com.example.threadstest I/ALI: on next : 1
//        2022-04-23 20:37:49.612 32043-32043/com.example.threadstest I/ALI: on next : 12

        //___________________________________________________________________________________________________________//



//        val observable=Observable.create<String>{ emmiter ->
//            binding.textInput.doOnTextChanged { text, start, before, count ->
//                emmiter.onNext(text.toString())
//            }
//        }.debounce(1,TimeUnit.SECONDS)
//        observable.subscribe(
//            {
//                    t-> Log.i("ALI","Searching for  : $t")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )

        // search for "product"
//        2022-04-23 20:45:40.625 2125-3359/com.example.threadstest I/ALI: Searching for  : p
//        2022-04-23 20:45:44.507 2125-3359/com.example.threadstest I/ALI: Searching for  : pr
//        2022-04-23 20:45:45.764 2125-3359/com.example.threadstest I/ALI: Searching for  : pro
//        2022-04-23 20:45:49.244 2125-3359/com.example.threadstest I/ALI: Searching for  : product


        //___________________________________________________________________________________________________________//


//        val observable=Observable.range(1,3)
//        observable.subscribeOn(Schedulers.computation()).subscribe(
//            {
//                    t-> Log.i("ALI","Searching for  : $t - ${Thread.currentThread().name}")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )
//        2022-04-23 21:03:20.440 5891-6032/com.example.threadstest I/ALI: Searching for  : 1 - RxComputationThreadPool-1
//        2022-04-23 21:03:20.440 5891-6032/com.example.threadstest I/ALI: Searching for  : 2 - RxComputationThreadPool-1
//        2022-04-23 21:03:20.441 5891-6032/com.example.threadstest I/ALI: Searching for  : 3 - RxComputationThreadPool-1

        //___________________________________________________________________________________________________________//

//        val observable=Observable.range(1,1)
//        observable.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//            {
//                    t-> Log.i("ALI","Searching for  : $t - ${Thread.currentThread().name}")
//            },{
//                    e-> Log.i("ALI","on Error")
//            }
//        )

        //2022-04-23 21:25:38.944 8972-8972/com.example.threadstest I/ALI: Searching for  : 1 - main

        //___________________________________________________________________________________________________________//



//        val single=Single.just(1)
//        single.subscribe(object : SingleObserver <Int> {
//            override fun onSubscribe(d: Disposable?) {
//                Log.i("ALI","on Subscribe - disposable is $d")
//            }
//
//            override fun onSuccess(t: Int?) {
//                Log.i("ALI","on Success $t")
//            }
//
//            override fun onError(e: Throwable?) {
//                Log.i("ALI","on Error")
//            }
//        })
//        2022-04-23 22:13:01.959 20109-20109/com.example.threadstest I/ALI: on Subscribe - disposable is INSTANCE
//        2022-04-23 22:13:01.959 20109-20109/com.example.threadstest I/ALI: on Success 1


        //___________________________________________________________________________________________________________//


//        val single=Single.just(1)
//        single.subscribe(::onDataSuccess,::onDataFail)

//        val completable=Completable.create {  emitter->
//            binding.textInput.doOnTextChanged { text, start, before, count ->
//                if (text.toString()=="A"){
//                    emitter.onComplete()
//                }
//            }
//        }
//        completable.subscribe(object : CompletableObserver {
//            override fun onSubscribe(d: Disposable?) {
//                Log.i("ALI","on Subscribe")
//            }
//
//            override fun onComplete() {
//                Log.i("ALI","on Complete")
//            }
//
//            override fun onError(e: Throwable?) {
//                Log.i("ALI","on Error")
//            }
//
//        })

        //___________________________________________________________________________________________________________//


//        val maybe=Maybe.create<String> { emitter ->
//            binding.textInput.doOnTextChanged { text, start, before, count ->
//                when (text.toString()) {
//                    "hello" -> emitter.onSuccess("Success")
//                    "yes" -> emitter.onComplete()
//                }
//            }
//        }
//        maybe.subscribe(object : MaybeObserver <String>{
//            override fun onSubscribe(d: Disposable?) {
//                Log.i("ALI","on Subscribe")
//            }
//
//            override fun onSuccess(t: String?) {
//                Log.i("ALI","on Success $t")
//            }
//
//            override fun onError(e: Throwable?) {
//                Log.i("ALI","on Error ${e?.message}")
//            }
//
//            override fun onComplete() {
//                Log.i("ALI","on Complete")
//            }
//
//        })

        //___________________________________________________________________________________________________________//

//        val flowable=Flowable.range(1,10000)
//        flowable.onBackpressureLatest().observeOn(Schedulers.io(),false,5)
//            .subscribe(
//                {
//                it->
//                    Log.i("ALI","on subscribe $it")
//                },{
//                    e->
//                    Log.i("ALI","on Error ${e?.message}")
//                },
//                {
//                    Log.i("ALI","on Complete")
//                }
//            )

//        2022-04-23 23:13:40.884 31491-31563/com.example.threadstest I/ALI: on subscribe 9942
//        2022-04-23 23:13:40.884 31491-31563/com.example.threadstest I/ALI: on subscribe 10000
//        2022-04-23 23:13:40.884 31491-31563/com.example.threadstest I/ALI: on Complete
        // iam ensure i will have the latest value when i use onBackpressureLatest()


        //___________________________________________________________________________________________________________//


//        val observable =Observable.range(1,5)
//
//        observable.toFlowable(BackpressureStrategy.LATEST).observeOn(Schedulers.io())
//                    .subscribe(
//                {
//                it->
//                    Log.i("ALI","on subscribe $it")
//                },{
//                    e->
//                    Log.i("ALI","on Error ${e?.message}")
//                },
//                {
//                    Log.i("ALI","on Complete")
//                }
//            )

        //___________________________________________________________________________________________________________//


//        val observable=Observable.interval(1,TimeUnit.SECONDS).take(10)
//
//        observable.subscribe(
//            {
//                t->Log.i("ALI","on subscribe $t")
//            },{
//                e->Log.i("ALI","on subscribe ${e.message}")
//            }
//        )
//
//        Thread.sleep(2000)
//
//        observable.subscribe(
//            {
//                    t->Log.i("ALI","on subscribe $t")
//            },{
//                    e->Log.i("ALI","on subscribe ${e.message}")
//            }
//        )

        //___________________________________________________________________________________________________________//


//        val observable=Observable.interval(1,TimeUnit.SECONDS).take(10).publish()
//
//        observable.connect()
//
//        observable.subscribe(
//            {
//                t->Log.i("ALI","on subscribe $t")
//            },{
//                e->Log.i("ALI","on subscribe ${e.message}")
//            }
//        )
//
//        Thread.sleep(2000)
//
//        observable.subscribe(
//            {
//                    t->Log.i("ALI","on subscribe $t")
//            },{
//                    e->Log.i("ALI","on subscribe ${e.message}")
//            }
//        )
//
//        2022-04-23 23:55:41.831 4875-4987/com.example.threadstest I/ALI: on subscribe 0
//        2022-04-23 23:55:42.831 4875-4987/com.example.threadstest I/ALI: on subscribe 1
//        2022-04-23 23:55:43.833 4875-4987/com.example.threadstest I/ALI: on subscribe 2
//        2022-04-23 23:55:43.833 4875-4987/com.example.threadstest I/ALI: on subscribe 2
//        2022-04-23 23:55:44.832 4875-4987/com.example.threadstest I/ALI: on subscribe 3
//        2022-04-23 23:55:45.831 4875-4987/com.example.threadstest I/ALI: on subscribe 4
//        2022-04-23 23:55:45.831 4875-4987/com.example.threadstest I/ALI: on subscribe 4
//        2022-04-23 23:55:46.832 4875-4987/com.example.threadstest I/ALI: on subscribe 5
//        2022-04-23 23:55:46.832 4875-4987/com.example.threadstest I/ALI: on subscribe 5
//        2022-04-23 23:55:47.832 4875-4987/com.example.threadstest I/ALI: on subscribe 6
//        2022-04-23 23:55:48.832 4875-4987/com.example.threadstest I/ALI: on subscribe 7
//        2022-04-23 23:55:48.832 4875-4987/com.example.threadstest I/ALI: on subscribe 7


        //___________________________________________________________________________________________________________//


//        val observable=Observable.interval(1,TimeUnit.SECONDS).take(10).publish()
//
//        observable.connect()
//
//
//        Thread.sleep(5000)
//
//        observable.subscribe(
//            {
//                t->Log.i("ALI","on subscribe $t")
//            },{
//                e->Log.i("ALI","on subscribe ${e.message}")
//            }
//        )
//
//        Thread.sleep(5000)
//
//        observable.subscribe(
//            {
//                    t->Log.i("ALI","on subscribe $t")
//            },{
//                    e->Log.i("ALI","on subscribe ${e.message}")
//            }
//        )

//        2022-04-23 23:59:35.360 7213-7314/com.example.threadstest I/ALI: on subscribe 5
//        2022-04-23 23:59:36.360 7213-7314/com.Time.threadstest I/ALI: on subscribe 6
//        2022-04-23 23:59:
//        37.360 7213-7314/com.example.threadstest I/ALI: on subscribe 7
//        2022-04-23 23:59:38.360 7213-7314/com.example.threadstest I/ALI: on subscribe 8
//        2022-04-23 23:59:39.361 7213-7314/com.example.threadstest I/ALI: on subscribe 9
        
        //first observer will start after 5 s form observable so will miss the beginig values


        //___________________________________________________________________________________________________________//

//        val observable = Observable.interval(1,TimeUnit.SECONDS).take(5)
//
//        val subject =PublishSubject.create<Long>()
//        // we will use subject like observer subscribe at observable
//
//        observable.subscribe(subject)
//
//        Thread.sleep(2000)
//
//        subject.subscribe(
//            {
//                Log.i("ALI","on subscribe $it")
//            },{
//                Log.i("ALI","on subscribe ${it?.message}")
//            }
//        )
//
//        2022-04-24 11:16:36.304 2663-2735/com.example.threadstest I/ALI: on subscribe 2
//        2022-04-24 11:16:37.304 2663-2735/com.example.threadstest I/ALI: on subscribe 3
//        2022-04-24 11:16:38.304 2663-2735/com.example.threadstest I/ALI: on subscribe 4

        //___________________________________________________________________________________________________________//

//        val subject =PublishSubject.create<Int>()
//
//        subject.onNext(2)
//        subject.onNext(4)
//
//        subject.subscribe(
//            {
//                Log.i("ALI","on subscribe $it")
//            },{
//                Log.i("ALI","on Error ${it?.message}")
//            }
//        )

//        subject.onNext(8)
//        subject.onNext(10)

//        2022-04-24 11:24:31.179 6360-6360/com.example.threadstest I/ALI: on subscribe 8
//        2022-04-24 11:24:31.179 6360-6360/com.example.threadstest I/ALI: on subscribe 10
// we will get the emitting valuese after subscribe because PublishSubject is hot observable .

        //___________________________________________________________________________________________________________//

//        val observable = Observable.interval(500,TimeUnit.MILLISECONDS).take(5)
//
//        val subject =AsyncSubject.create<Long>()
//        // we will use subject like observer subscribe at observable
//
//        observable.subscribe(subject)
//
//        Thread.sleep(8000)
//
//        subject.subscribe(
//            {
//                Log.i("ALI","on subscribe $it")
//            },{
//                Log.i("ALI","on subscribe ${it?.message}")
//            }
//        )
//
//        we will get the final element even if the emitting data finished
//
//        2022-04-24 11:38:34.613 11423-11512/com.example.threadstest I/ALI: on subscribe 4


        //___________________________________________________________________________________________________________//


//        val observable = Observable.interval(2,TimeUnit.SECONDS).take(5)
//
//        val subject =BehaviorSubject.create<Long>()
//        // we will use subject like observer subscribe at observable
//
//        observable.subscribe(subject)
//
//        Thread.sleep(8000)
//
//        subject.subscribe(
//            {
//                Log.i("ALI","on subscribe $it")
//            },{
//                Log.i("ALI","on Error ${it?.message}")
//            }
//        )
//        2022-04-24 11:51:26.948 18383-18383/com.example.threadstest I/ALI: on subscribe 3
//        2022-04-24 11:51:28.948 18383-18495/com.example.threadstest I/ALI: on subscribe 4

        //___________________________________________________________________________________________________________//


//        val subject =BehaviorSubject.create<Long>()
//
//        subject.onNext(5)
//        subject.onNext(20)
//
//        subject.subscribe(
//            {
//                Log.i("ALI","on subscribe $it")
//            },{
//                Log.i("ALI","on Error ${it?.message}")
//            }
//        )
//
//        subject.onNext(3)
//        subject.onNext(4)
//
//        2022-04-24 11:56:04.419 20541-20541/com.example.threadstest I/ALI: on subscribe 20
//        2022-04-24 11:56:04.419 20541-20541/com.example.threadstest I/ALI: on subscribe 3
//        2022-04-24 11:56:04.420 20541-20541/com.example.threadstest I/ALI: on subscribe 4

        //___________________________________________________________________________________________________________//



//        val observable = Observable.interval(3000,TimeUnit.MILLISECONDS).take(5)
//
//        val subject =ReplaySubject.create<Long>()
//        // we will use subject like observer subscribe at observable
//
//        observable.subscribe(subject)
//
//        Thread.sleep(4000)
//
//        subject.subscribe(
//            {
//                Log.i("ALI","on subscribe $it")
//            },{
//                Log.i("ALI","on Error ${it?.message}")
//            }
//        )
//
//        2022-04-24 12:05:50.073 25403-25403/com.example.threadstest I/ALI: on subscribe 0
//        2022-04-24 12:05:52.069 25403-25483/com.example.threadstest I/ALI: on subscribe 1
//        2022-04-24 12:05:55.069 25403-25483/com.example.threadstest I/ALI: on subscribe 2
//        2022-04-24 12:05:58.070 25403-25483/com.example.threadstest I/ALI: on subscribe 3
//        2022-04-24 12:06:01.072 25403-25483/com.example.threadstest I/ALI: on subscribe 4

        //___________________________________________________________________________________________________________//




    }



    private fun onDataSuccess(result :Int){
        Log.i("ALI","Success ${result}")
    }
    private fun onDataFail(e:Throwable){
        Log.i("ALI","Fail ${e.message}")
    }



    override fun onDestroy() {
        disposable.dispose()
        compositeDisposable.dispose()
        super.onDestroy()
    }
}



/*

 [ Opertor ]: just , fromArray ,fromIterator,repeat,range,intervals,take,takeLast,skip,timer,distinct
 ,buffer,map,concat,mergeWith,ZipWith,flatMap,create,debounce,.........

           _____________________________________________________________________________________________

-just take from 1 to 10 value
-from more than 10 values , arrray of item
-fromIterable get source :list,iterable,Mutable List
-range(1,20) first param START , second COUNT params
-interval repeate onNext every x values of seconds,minutes,.. for infinite
-take 4 count :take first 4 item
-take(4,TimeUnit.SECONDS) take items in the first 4 Seconds
-skip : skip firt x elements
-timer : run onNext after x seconds, minutes,..
-distinct : Delete duplicate values
-buffer: when we have alot of date you can store alot of date in buffer and
-send it once time instead of send single item every once
-map : change the element
-concat : Same DataType
-merge : Overlap emitting between the first observble and second observable
-flatMap : for every item will return observable
-create : date willnot emitting automatically , you can control the emitting data
-debounce : useful in searching ,You can search for a letter by letter with a period of time for each letter before it is sent

                 _____________________________________________________________________________________
 can specify where the observable will run by Class Schedulers
-you
-you can choose a new Thread but The process of creating  newThread is costly for resources. It is not recommended to use it,
 so rxjava has provided a set of threads :
    Computation,io(),Single,Shutdown,start,trampoline

In the application it can be more than observable so when you use thread type from rxjava it will not create the thread again
After we got adata from rxjava Thread we need to acces to main thread to display data in the ui

                 _____________________________________________________________________________________

subscribeOn : Makes the process run on a specific thread and returns the output on the same thread.
observeOn : The output that returns put in AndroidSchedulers.mainThread
subscribe : return an object of Disposable type , observer who subscribe on the observable

                  _____________________________________________________________________________________

 Difference between Disposable & CompositeDisposable :
 [disposable] we must create disposable object for every observable, and onDestroy you should dispose every disposable object ^_^
 [CompositeDisposable] you can create one object of it and add it for every observable and in onDestroy you can dispose just one compositeDisposable object ^_^

             ________________________________________________________________________________________________

Observables 5 Types
 Observable
 Single
 Completable
 Maybe
 Flowable

Difference between Observable & Flowable  "Same in alot of time"
observable some times when emitting alot of data 100000 items , the observer not hold and the app will crash ^@@^
Flowable , observer can handle and control when recive alot of data

                ________________________________________________________________________________________________

Observers 4 Types
 Observer
 Single Observer
 Completable Observer
 Maybe Observer


              _______________________________________________________________________________________

[ Flowable : Neglecting uncontrollable data  ]

 BackPressure Strategy :

 -Drop : Data that you can't keep up Drop it
 -Buffer : use buffer to store data
 -Latest : Ensure that it is the last value you will have so it will stay updated
 -Missing : No backpressure strategy used ,throw run time error , try/catch
 -Error : you will use backpressure strategy but you can have error

Convert Observable to Flowable

Cold Observables Vs Hot Observables
cold observables { Observable , Single , Completable , Maybe , Flowable } because we can get a data from first to end

convert from cold observable to hot just add puplish() so the tow observer will get the same date in the same time


             --------------------------------------------------------------------------------------------

A Subject is a sort of bridge or proxy that is available in some implementations of ReactiveX that acts both as an observer and as an Observable.
Because it is an observer, it can subscribe to one or more Observables, and because it is an Observable, it can pass through the items it observes by reemitting them,
    and it can also emit new items.

Because a Subject subscribes to an Observable, it will trigger that Observable to begin emitting items (if that Observable is “cold” — that is, if it waits for a subscription before it begins to emit items).
This can have the effect of making the resulting Subject a “hot” Observable variant of the original “cold” Observable.

 *_* Subject is Hot Observable but in some operators is cold operator .


Subject Types :
- AsyncSubject
- ReplaySubject
- BehaviorSubject
- PublishSubject

[ PublishSubject ] : PublishSubject emits to an observer only those items that are emitted by the source Observable(s) subsequent to the time of the subscription.

Note that a PublishSubject may begin emitting items immediately upon creation (unless you have taken steps to prevent this),
 and so there is a risk that one or more items may be lost between the time the Subject is created and the observer subscribes to it.
  If you need to guarantee delivery of all items from the source Observable,
  you’ll need either to form that Observable with Create so that you can manually reintroduce “cold” Observable behavior (checking to see that all observers have subscribed before beginning to emit items), or switch to using a ReplaySubject instead.

                      -----------------------------------------------------------------------
[ AsyncSubject ] : will get final value after the obsevable finish emitting at every time your AsyncSubject observer subscibe it

An AsyncSubject emits the last value (and only the last value) emitted by the source Observable,
and only after that source Observable completes. (If the source Observable does not emit any values, the AsyncSubject also completes without emitting any values.)

It will also emit this same final value to any subsequent observers. However, if the source Observable terminates with an error, the AsyncSubject will not emit any items,
 but will simply pass along the error notification from the source Observable.

                             -----------------------------------------------------------------------

[ BehaviorSubject ] : When you make a subscription, it will get the last value emitting by the observable before you make a subscription and then complete receiving the new values from observable

When an observer subscribes to a BehaviorSubject, it begins by emitting the item most recently emitted by the source Observable (or a seed/default value if none has yet been emitted)
 and then continues to emit any other items emitted later by the source Observable(s).

However, if the source Observable terminates with an error, the BehaviorSubject will not emit any items to subsequent observers,
but will simply pass along the error notification from the source Observable.

                              -----------------------------------------------------------------------

[ ReplaySubject ] : All values that were sent before you made a subscription will be sent back and you will continue to receive the new values .

ReplaySubject emits to any observer all of the items that were emitted by the source Observable(s), regardless of when the observer subscribes.

There are also versions of ReplaySubject that will throw away old items once the replay buffer threatens to grow beyond a certain size, or when a specified timespan has passed since the items were originally emitted.

If you use a ReplaySubject as an observer, take care not to call its onNext method (or its other on methods) from multiple threads, as this could lead to coincident (non-sequential) calls,
which violates the Observable contract and creates an ambiguity in the resulting Subject as to which item or notification should be replayed first.

*/