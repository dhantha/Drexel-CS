#!/usr/bin/bash


def memoize(fn):
	memo_list = ['0']*100
		
	def dec_func(*args):
		arg = args[0]
		if memo_list[arg] != '0':
			return memo_list[arg]
		else:
			memo_list[arg] = fn(arg)
			return memo_list[arg]
	return dec_func