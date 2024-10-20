module Main where
makeGreeting salutation person =
    salutation <> " " <> person

main = print (makeGreeting "hello" "hans")