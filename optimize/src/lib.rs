extern crate jni;

use jni::objects::JClass;
use jni::objects::JList;
use jni::objects::JString;
use jni::JNIEnv;
use aho_corasick::AhoCorasickBuilder;

#[no_mangle]
#[allow(non_snake_case)]
pub extern fn Java_App_hello(_env: JNIEnv, _class: JClass) {
    println!("hello from rust!!!");
}

#[no_mangle]
#[allow(non_snake_case)]
pub extern fn Java_App_match(_env: JNIEnv, _class: JClass, keywords: JList, text: JString) -> Vec<usize> {
    let ac = AhoCorasickBuilder::new()
        .ascii_case_insensitive(true)
        .build(keywords.collect::<Vec<_>>());
    let mut matches = Vec<usize>::new();

    for mat in ac.find_iter(text) {
        matches.push(vec![mat.start(), mat.end()]);
    }
    matches
}
